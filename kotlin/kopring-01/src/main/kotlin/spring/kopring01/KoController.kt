package spring.kopring01

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/first")
class KoController {

    @GetMapping("/{name}/{age}")
    fun first(@PathVariable(name = "name") name: String, @PathVariable(name = "age") age: Int): String {
        return "Hello $name / $age";
    }

    @PostMapping("/rm")
    fun firstRequestMapping(@RequestBody dto: KoDto) {
        dto.age;
        dto.name;
        dto.message = "this is message.";

    }
}