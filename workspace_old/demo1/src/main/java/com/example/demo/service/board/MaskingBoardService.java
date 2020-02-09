package com.example.demo.service.board;

import java.util.List;
import java.util.stream.Collectors;

public class MaskingBoardService extends JongpakBoardService {

	@Override
	public List<String> getArticleList() {
		return super.getArticleList()
				.stream()
				.map(subject -> subject.charAt(0) + "*****")
				.collect(Collectors.toList());
	}

}
