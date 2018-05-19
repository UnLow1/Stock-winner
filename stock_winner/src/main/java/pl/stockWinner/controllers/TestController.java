package pl.stockWinner.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path="/api")
public class TestController {

    @GetMapping(path = "/hello-world")
    public ResponseEntity<?> helloWorld(){
        return ResponseEntity.ok(new Message("Hello World!"));
    }

    @GetMapping(path = "/greetings/{name}")
    public ResponseEntity<?> greetings(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(new Message("Hello "+name+"!"));
    }

    public class Message {
        private String text;

        public Message(String text) {
            this.text = text;
        }

        public Message() {
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
