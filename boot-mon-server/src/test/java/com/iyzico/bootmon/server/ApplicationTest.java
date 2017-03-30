package com.iyzico.bootmon.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Application.class)
public class ApplicationTest {
}
