package com.maocq.virtualthreads.infrastructure.entrypoint.apirest;

import com.maocq.virtualthreads.domain.model.account.Account;
import com.maocq.virtualthreads.domain.model.user.User;
import com.maocq.virtualthreads.domain.usecase.CasesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ApiRest {

    private final CasesUseCase useCases;

    @GetMapping("/api/hello")
    String hello() {
        return "Hello world!";
    }

    @GetMapping("/api/case-one")
    String caseOne(@RequestParam Optional<Integer> latency) {
        var latencyParam = latency.orElse(0);
        return useCases.caseOne(latencyParam);
    }

    @GetMapping("/api/case-two")
    User caseTwo(@RequestParam Optional<Integer> latency) {
        var latencyParam = latency.orElse(0);
        return useCases.caseTwo(latencyParam);
    }

    @GetMapping(path = "/api/case-three")
    public Optional<Account> caseThree() {
        return useCases.caseThree(4000);
    }

    @GetMapping(path = "/api/case-four")
    public Account caseFour(@RequestParam Optional<Integer> latency) {
        var latencyParam = latency.orElse(0);
        return useCases.caseFour(4000, latencyParam);
    }
}
