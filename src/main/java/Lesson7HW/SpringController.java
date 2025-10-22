package Lesson7HW;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
public class SpringController {

    @PostMapping()
    public ResponseEntity<ResponseDate> postReq(@RequestBody PostDate postDate){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newStartDate = LocalDate.parse(postDate.getStartDate(), dateFormatter);
        LocalDate newEndDate = LocalDate.parse(postDate.getEndDate(), dateFormatter);

        Random random = new Random();
        long daysBetween = ChronoUnit.DAYS.between(newStartDate, newEndDate);
        long randomDays = random.nextLong(daysBetween + 1);

        return ResponseEntity.ok(new ResponseDate(newStartDate.plusDays(randomDays)));
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseListInteger> postReqNumber(@RequestParam("isAsc") boolean isAsc, @RequestBody List<Integer> number){
        List<Integer> respArray = (isAsc) ? number.stream()
                .sorted(Comparator.naturalOrder())
                .toList() : number.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        return ResponseEntity.ok(new ResponseListInteger(respArray));
    }

    @PostMapping("/posttext")
    public ResponseEntity<List> getText(@RequestBody TextRequest text){
        String str = text.getText();
        return ResponseEntity.ok(CharFr.countChar(str));
    }

    @PostMapping("/postnumbers")
    public ResponseEntity<SumInt> numbers(@RequestBody List<Integer> listInt){
        return ResponseEntity.ok(new SumInt(listInt.stream().mapToInt(Integer::intValue).sum()));
    }

    @PostMapping("/postsumif")
    public ResponseEntity sumifs(@RequestBody SumIf sumif) {
        Map<Integer, Boolean> a = SumIf.createMap(sumif.getNumbers(), sumif.getConditions());
        Integer res  = a.entrySet().stream()
                .filter(entry -> entry.getValue() == true)
                .mapToInt(entryInt -> entryInt.getKey())
                .sum();

        return ResponseEntity.ok(new SumRes(res));
    }


}
