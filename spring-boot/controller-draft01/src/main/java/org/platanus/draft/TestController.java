package org.platanus.draft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/aa")
	public String testController() {
		return "asdf";
	}
	
	@PostMapping("/bb")
	@ResponseBody
	public TestStringVO postTestController(@RequestBody TestStringVO testStringVO) {
		return testStringVO;
	}

}


