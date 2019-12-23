package cc.wsapps.common.mapper;

import cc.wsapps.common.entity.Sequence;
import cc.wsapps.common.example.SequenceExample;
import cc.wsapps.common.example.SequenceExamplePage;
import cc.wsapps.framework.dao.BaseMapper;

public interface SequenceMapper extends BaseMapper<SequenceExample, SequenceExamplePage, Sequence> {
	
	Sequence selectBySeqId(Long id);
}