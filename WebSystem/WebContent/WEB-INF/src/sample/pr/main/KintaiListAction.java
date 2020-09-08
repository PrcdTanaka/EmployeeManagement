package sample.pr.main;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample.pr.main/KintaiListAction")
public class KintaiListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KintaiListAction()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		prepData(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/KintaiList.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	private void prepData(HttpServletRequest request)
	{
		int startday;
		int lastday;

		// カレンダーの取得
		Calendar cal = Calendar.getInstance();

		// 年が設定されていれば、その値を取得。
		// そうでなければ、今年の年号を入れる
		if(request.getParameter("year") == null)
		{
			request.setAttribute("year", cal.get(Calendar.YEAR));
		}
		else
		{
			request.setAttribute("year", request.getParameter("year"));
		}

		if(request.getParameter("month") == null)
		{
			request.setAttribute("month", cal.get(Calendar.MONTH)+1);
		}
		else
		{
			request.setAttribute("month", request.getParameter("month"));
		}

		int year = Integer.parseInt(request.getAttribute("yaer").toString());
		int month = Integer.parseInt(request.getAttribute("month").toString());

		// 月初めの曜日(日→1)
		cal.set(year, month - 1, 1);
		startday = cal.get(Calendar.DAY_OF_WEEK);

		// 月末の日付
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		lastday = cal.get(Calendar.DATE);

		// カレンダーのデータを作成する
		int date = 1;
		int maxday = 6*7;
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th style=\"color:red;\">日</th>");
		sb.append("<th>月</th><th>火</th><th>水</th><th>木</th><th>金</th>");
		sb.append("<th style=\"color:bule;\">土</th>");
		sb.append("</tr>");
		sb.append("<tr>");

		for(int num = 1; num <= maxday; num++)
		{
			if(num < startday || num > lastday + startday -1)
			{
				sb.append("<td></td>");
			}
			else
			{
				sb.append("<td>" + date + "</td>");
				date++;
			}
			if(num % 7 == 0)
			{
				sb.append("</tr>");
				if(num > startday + lastday -1)
				{
					break;
				}
				if(date < lastday)
				{
					sb.append("<tr>");
				}
				else
				{
					// 最後だったら、ループから抜ける
					break;
				}
			}
		}
		sb.append("</table>");

		// パラメータを設定
		request.setAttribute("calendar", sb);
		return;
	}

}
