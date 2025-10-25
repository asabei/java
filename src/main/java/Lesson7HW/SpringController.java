package Lesson7HW;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
public class SpringController {
    private final String s = "СОБЫТЕ";
    @PostMapping()
    public ResponseEntity<ResponseDate> postReq(@RequestBody PostDate postDate){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newStartDate = LocalDate.parse(postDate.getStartDate(), dateFormatter);
        LocalDate newEndDate = LocalDate.parse(postDate.getEndDate(), dateFormatter);

        Random random = new Random();
        long daysBetween = ChronoUnit.DAYS.between(newStartDate, newEndDate);
        long randomDays = random.nextLong(daysBetween + 1);
        LogerService.writeLog(s, new ResponseDate(newStartDate.plusDays(randomDays)).toString());
        return ResponseEntity.ok(new ResponseDate(newStartDate.plusDays(randomDays)));
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseListInteger> postReqNumber(@RequestParam("isAsc") boolean isAsc, @RequestBody List<Integer> number){
        List<Integer> respArray = (isAsc) ? number.stream()
                .sorted(Comparator.naturalOrder())
                .toList() : number.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        LogerService.writeLog(s, new ResponseListInteger(respArray).toString());

        return ResponseEntity.ok(new ResponseListInteger(respArray));
    }

    @PostMapping("/posttext")
    public ResponseEntity<List> getText(@RequestBody TextRequest text){
        String str = text.getText();
        LogerService.writeLog(s, CharFr.countChar(str).toString());
        return ResponseEntity.ok(CharFr.countChar(str));
    }

    @PostMapping("/postnumbers")
    public ResponseEntity<SumInt> numbers(@RequestBody List<Integer> listInt){

        LogerService.writeLog(s, new SumInt(listInt.stream().mapToInt(Integer::intValue).sum()).toString());
        return ResponseEntity.ok(new SumInt(listInt.stream().mapToInt(Integer::intValue).sum()));
    }

    @PostMapping("/postsumif")
    public ResponseEntity sumifs(@RequestBody SumIf sumif) {
        Map<Integer, Boolean> a = SumIf.createMap(sumif.getNumbers(), sumif.getConditions());
        Integer res  = a.entrySet().stream()
                .filter(entry -> entry.getValue() == true)
                .mapToInt(entryInt -> entryInt.getKey())
                .sum();

        LogerService.writeLog(s, new SumRes(res).toString());
        return ResponseEntity.ok(new SumRes(res));
    }

    @GetMapping("/getLogs")
    public String getLogs(){
        List<String> logs = LogerService.readLog();
        StringBuilder res = new StringBuilder();
        for (String log: logs) {
            res.append(log).append("<br>");
        }
        return res.toString();
    }


}
