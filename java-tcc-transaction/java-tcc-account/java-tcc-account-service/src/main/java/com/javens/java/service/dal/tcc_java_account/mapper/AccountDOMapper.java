package com.javens.java.service.dal.tcc_java_account.mapper;
import org.apache.ibatis.annotations.Param;
import com.javens.java.service.dal.tcc_java_account.dataobject.AccountDO;
/**
*
* The Table TCC_ACCOUNT.
* TCC_ACCOUNT
*/
public interface AccountDOMapper{

    /**
    * desc:insert:TCC_ACCOUNT.<br/>
    * descSql = INSERT INTO TCC_ACCOUNT VALUES 
        * @param entity entity
    * @return Long
    */
        Long insert(AccountDO entity);
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ACCOUNT WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 LIMIT 1
        * @param id id
    * @return AccountDO
    */
        AccountDO getById(Integer id);
    /**
    * desc:获取记录.<br/>
    * descSql =  SELECT * FROM TCC_ACCOUNT WHERE id =#{id,jdbcType=INTEGER} and IS_DEL = 0 FOR UPDATE
        * @param id id
    * @return AccountDO
    */
        AccountDO getByIdForUpdate(Integer id);
    /**
    * desc:修改账户金额.<br/>
    * descSql =  UPDATE TCC_ACCOUNT SET amount = amount + #{amount,jdbcType=DECIMAL} where id = #{id,jdbcType=INTEGER} and IS_DEL = 0
        * @param entity entity
    * @return Long
    */
        Long updateAccountBalance(AccountDO entity);
}
