package com.yo.news.clip.dao;

import java.util.List;

import com.yo.news.clip.impl.BaseDao;
import com.yo.news.clip.vo.ClipModel;
 

public interface ClipDao extends BaseDao<ClipModel>  {

	/**
	 * 通过用户主键获取素材列表
	 * 
	 * @author Michael
	 * @param userId 用户主键
	 * @param firstFrom 起始记录
	 * @param needCount 每页返回记录数
	 * @return
	 */
	List<ClipModel> getClipsByUserId(String userId, Integer firstFrom, Integer needCount);

	/**
	 * 根据aliKey查询素材，用于上传素材时防止重复添加同一素材
	 * 
	 * @author Michael
	 * @param aliKey
	 * @return 素材个数
	 */
	ClipModel getClipByAliKey(String aliKey);

	/**
	 * 批量添加素材
	 * 
	 * @author Michael
	 * @param batchClips
	 *            批量添加素材集合
	 * @return
	 */
	int addBatch(List<ClipModel> batchClips);

	/**
	 * 获取素材时长
	 * 
	 * @author Michael
	 * @param clipId
	 * @return
	 */
	Integer getLengthByClipId(String clipId);

	int delClipsByScriptId(String scriptId);

 

}
