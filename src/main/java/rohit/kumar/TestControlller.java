package rohit.kumar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rohit")
public class TestControlller {

	@GetMapping("/kumar")
	public String test()
	{
		return "checking multiple component scanning";
	}
}
