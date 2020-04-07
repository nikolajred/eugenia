
package com.nix.eugenia.controllers;


        import com.nix.eugenia.services.StudentServiceImpl;
        import lombok.RequiredArgsConstructor;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/room/{id}")
@RequiredArgsConstructor
public class StudentRoomController {
    private final  StudentServiceImpl studentService;

    @GetMapping
    public String joinLesson(@PathVariable(name ="id") Long studentId ) {
        return   studentService.joinLesson(studentId);
    }
}
