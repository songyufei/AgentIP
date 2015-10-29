package com.silence.agentip.crawler;

import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class XiciDailiCrawler extends BreadthCrawler{

	public XiciDailiCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Page page, Links nextLinks) {
		System.out.println("遍历的"+page.getUrl());
		//String question=page.getDoc().select("table[id=ip_list] tbody").text();
		Elements trElements = page.getDoc().select("tr");
		System.out.println("url="+page.getUrl()+"size="+trElements.size());
		for(int i=1;i<trElements.size();i++){
			System.out.println(trElements.get(i).text());
			String[] array = trElements.get(i).text().split(" ");
			System.out.println(array.length);
		}
//		String question_regex="^http://www.xicidaili.com/nn/[1-9]+";
//		if(Pattern.matches(question_regex, page.getUrl())){
//		}
	}
	
	public static void main(String[] args) throws Exception {
		XiciDailiCrawler crawler = new XiciDailiCrawler("/Users/SilencE/Developer/crawler",false);
		crawler.setThreads(20);
		for(int i=1;i<2;i++){
			crawler.addSeed("http://www.xicidaili.com/nn/"+i);
		}
		//crawler.addRegex("http://www.xicidaili.com/nn/[1-9]+");
		//crawler.setTopN(1);
		crawler.start(1);
		System.out.println("爬去完毕");
	}

}
