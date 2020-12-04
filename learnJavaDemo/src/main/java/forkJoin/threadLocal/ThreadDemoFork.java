package forkJoin.threadLocal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThreadDemoFork {
     private String msg;
    private final String INIT_MSG = "初始threadLocal消息";

}
