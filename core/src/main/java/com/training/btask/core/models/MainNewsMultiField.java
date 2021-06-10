package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MainNewsMultiField {
	@Inject
	String title;
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public String getDate() {
		return date;
	}
	public String getAuthor() {
		return author;
	}
	public List<NewsParagraph> getNews() {
		return news;
	}
	@Inject
	String heading;
	public String getHeading() {
		return heading;
	}
	@Inject
	String image;
	@Inject
	String date;
	@Inject
	String author;
	@Inject
	List<NewsParagraph> news;
	 

}
