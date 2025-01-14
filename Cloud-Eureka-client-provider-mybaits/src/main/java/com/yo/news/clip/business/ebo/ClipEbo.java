/**
 * 
 */
package com.yo.news.clip.business.ebo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import com.yo.news.clip.dao.ClipDao;
import com.yo.news.clip.vo.ClipModel;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年7月12日 下午4:18:03 说明：
 */
@Service
public class ClipEbo
{
	@Autowired
	private ClipDao clipDao;

	public ClipModel getClipDetail(String userId, String clipId)
	{

		ClipModel clipModel = clipDao.selectByPrimaryKey(clipId);
		if (clipModel == null)
		{
			return null;
		}
		return clipModel;
	}
}
