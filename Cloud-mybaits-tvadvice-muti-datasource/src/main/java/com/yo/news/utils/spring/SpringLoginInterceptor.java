/**
 * 
 */
package com.yo.news.utils.spring;

import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.yo.base.utils.base.MyString;
import com.yo.news.utils.enums.EErrorCodes;
import com.yo.news.utils.service.CmdRequestM;
import com.yo.news.utils.service.CmdResponseM;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2015年4月21日 上午9:20:55 说明：
 */
public class SpringLoginInterceptor implements MethodInterceptor
{
	final Object requestLock = 1;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
//		CmdResponseM responseM = new CmdResponseM();
//		Object[] args = invocation.getArguments();
//		CmdRequestM request = null;
//		HttpSession session = null;
//
//		for (int i = 0; i < args.length; i++)
//		{
//			if (args[i] instanceof CmdRequestM) request = (CmdRequestM) args[i];
//			if (args[i] instanceof HttpSession) session = (HttpSession) args[i];
//		}
//		if (request == null)
//		{
//			// 检验requestM是否为空
//			responseM.setErrorCode(EErrorCodes.INVALID_REQUEST_ERROR);
//			responseM.setErrorMessage("invalid request");
//			return responseM;
//		}
//		if (request.getRequestId() != null && isRepeatRequest(session, request.getRequestId()))
//		{
//			// 重复请求
//			responseM.setErrorCode(EErrorCodes.HTTP204);
//			responseM.setErrorMessage("repeated request");
//			return responseM;
//		}
//		if (session == null || isLogin(session, request.getToken()) == false)
//		{
//			responseM.setErrorCode(EErrorCodes.LOGIN_ERROR);
//			responseM.setErrorMessage("invalid identify");
//			return responseM;
//		}
		Object o;
//		try
//		{
			o = invocation.proceed();
//		}
//		finally
//		{
//			releaseRequestId(session, request.getRequestId());
//		}
		return o;
	}

	protected boolean isRepeatRequest(HttpSession session, String requestId)
	{
		if (MyString.IsNullOrEmpty(requestId))
		{
			return false;
		}
		Object o = session.getAttribute(requestId);
		if (o == null)
		{
			session.setAttribute(requestId, requestLock);
			return false;
		}
		return true;
	}

	protected void releaseRequestId(HttpSession session, String requestId)
	{
		session.removeAttribute(requestId);
	}

	protected boolean isLogin(HttpSession session, String token)
	{
 
		if (session == null)
		{
			return false;
		}
//		SessionModel sessionModel = getSessionModel(session);
//
//		if (sessionModel == null || session.isNew())
//		{
//
//			return false;
//		}
//		 
//		// 如果token为空，也说明其实未登录的session
//		if (MyString.IsNullOrEmpty(sessionModel.getToken()))// 此处用来判断token,防止csrf
//		{
//			return false;
//		}
	 
		return true;

	}

//	public SessionModel getSessionModel(HttpSession session)
//	{
//		SessionModel sessionModel = SessionHandler.getHttpSessionModel(session);
//		return sessionModel;
//	}
}
