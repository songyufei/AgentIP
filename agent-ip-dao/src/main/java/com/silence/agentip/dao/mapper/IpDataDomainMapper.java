package com.silence.agentip.dao.mapper;

import com.silence.agentip.dao.domain.IpDataDomain;
import com.silence.agentip.dao.domain.IpDataDomainCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IpDataDomainMapper{
    int countByExample(IpDataDomainCriteria example);

    int deleteByExample(IpDataDomainCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(IpDataDomain record);

    int insertSelective(IpDataDomain record);

    List<IpDataDomain> selectByExampleWithRowbounds(IpDataDomainCriteria example, RowBounds rowBounds);

    List<IpDataDomain> selectByExample(IpDataDomainCriteria example);

    IpDataDomain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IpDataDomain record, @Param("example") IpDataDomainCriteria example);

    int updateByExample(@Param("record") IpDataDomain record, @Param("example") IpDataDomainCriteria example);

    int updateByPrimaryKeySelective(IpDataDomain record);

    int updateByPrimaryKey(IpDataDomain record);
}