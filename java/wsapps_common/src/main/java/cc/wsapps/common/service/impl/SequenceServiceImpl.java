package cc.wsapps.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cc.wsapps.common.entity.Sequence;
import cc.wsapps.common.example.SequenceExample;
import cc.wsapps.common.mapper.SequenceMapper;
import cc.wsapps.common.service.SequenceService;
import cc.wsapps.framework.dao.TransactionService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/ss/")
public class SequenceServiceImpl implements SequenceService {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(SequenceServiceImpl.class);

	@Autowired
	private SequenceMapper sequenceMapper;
	
	@Resource(name = "commonTransactionService")
	private TransactionService commonTransactionService;
	
	private Map<String, SequenceBO> seqMap = null;
	
	@Override
	@GetMapping("nextSeq")
	public String next(@RequestParam String seqId) {
		LOG.debug("Method [nextSeq] : : seqMap:["+seqMap+"]");
		SequenceBO seq = seqMap.get(seqId);
		if (null == seq) {
			LOG.error("can not find Sequence Object by " + seqId);
			throw new RuntimeException("can not find Sequence Object by " + seqId);
		}
		String result = seq.next();
		if (null == result) {
			LOG.error("null point  Exception " + seqId);
			throw new RuntimeException("null point  Exception " + seqId);
		}
		return result;
	}
	
	@PostConstruct
	public void initialize() {
		
		List<Sequence> list = sequenceMapper.selectByExample(new SequenceExample());
		
		if (null != list) {
			seqMap = new HashMap<String, SequenceBO>();
			SequenceBO seqObj = null;
			
			for (Sequence seq : list) {
				seqObj = new SequenceBO();
				seqObj.id = seq.getId();
				seqObj.seqId = seq.getCode();
				seqObj.current = seq.getCurrent();
				seqObj.next = seq.getCurrent();
				seqObj.prefix = seq.getPrefix() == null ? "" : seq.getPrefix();
				seqObj.length = seq.getLength();
				seqObj.padding = "1".equals(seq.getPadding()) ? true : false;
				seqObj.paddingChar = seq.getPaddingchar();
				seqObj.step = seq.getStep();
				
				// store
				seqMap.put(seq.getCode(), seqObj);
			}
			
			LOG.debug("Method [initialize] : seqMap:["+seqMap+"]");
		}
	}
	
	private void bookSeq(String seqId, Long next){
		SequenceExample example = new SequenceExample();
		example.createCriteria().andCodeEqualTo(seqId);
		Sequence record = new Sequence();
		record.setCurrent(next);
		sequenceMapper.updateByExampleSelective(record, example);
	}
	
	private SequenceBO book(String seqId) {
		SequenceBO next = null;
		TransactionStatus ts = commonTransactionService.begin(2 * 60);
		try {
			SequenceBO bo = seqMap.get(seqId);
			Long id = bo.id;
			
			Sequence sequence = sequenceMapper.selectBySeqId(id);
			Long current = sequence.getCurrent();
			Integer subscriptCnt = sequence.getSubscriptions();
			Long max = sequence.getMax();
			Long min = sequence.getMin();
			
			boolean cycle = "1".equals(sequence.getCycle()) ? true : false;
					
			Long pnext = current + subscriptCnt;
			Long book = pnext;
			
			if (pnext.compareTo(max) <= 0) {
				book = pnext;
            } else {
                if (cycle) {
                    current = min;
                    book = current + subscriptCnt;
                } else {
                    LOG.error("Sequence Overflow, idKey=" + seqId);
                    throw new RuntimeException("Sequence Overflow, idKey=" + seqId);
                }
            }
			next = new SequenceBO();
			bookSeq(seqId, book);
			next.next = book;
			next.current = current;
			commonTransactionService.commit(ts);
		} catch (Throwable e) {
			LOG.error("initialize error", e);
			commonTransactionService.rollback(ts);
		}
		
		return next;
	}
	
	class SequenceBO {
		private Long id = null;
		private String seqId = null;
		private Long current = null;
		private Long next = null;
		private Integer step = null;
		private String prefix = null;
		private int length = 0;
		private boolean padding = true;
		private String paddingChar = "0";

		private byte[] lock = new byte[0];
		
		public String next() {
            synchronized (lock) {
                if (this.current.compareTo(this.next) < 0) {
                    return this.buildSeq();
                } else {
                    return this.bookAndbuildSeq();
                }
            }
        }

		private String bookAndbuildSeq() {
            /*Long pnext = this.current + this.bookCnt;
            if (pnext.compareTo(this.max) <= 0) {
                this.next = pnext;
            } else {
                if (this.cycle) {
                    this.current = this.min;
                    this.next = this.current + this.bookCnt;
                } else {
                    LOG.error("Sequence Overflow, idKey=" + this.seqId);
                    throw new RuntimeException("Sequence Overflow, idKey=" + this.seqId);
                }
            }*/
			
			SequenceBO newNext = book(seqId);
			String result = null;
			if (null != newNext) {
				current = newNext.current;
				next = newNext.next;
	            // save to db
	            //bookSeq(this.seqId, this.next.longValue());

	            // buid
				result= this.buildSeq();	
			}
			return result;
			
        }
		
		private String buildSeq() {
			// 此处算法可以再优化一下。
			this.current = this.current + this.step;
			String idx = this.current.toString();
			StringBuilder bud = new StringBuilder(idx);
			if (this.padding) {
				int pdlen = this.length - (this.prefix + idx).length();
				if (pdlen > 0) {
					while (pdlen-- > 0) {
						bud.insert(0, this.paddingChar);
					}
				}
			}
			bud.insert(0, this.prefix);
			return bud.toString();
		}
	}

}
