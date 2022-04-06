package telran.pulse.monitoring;

import java.util.function.Consumer;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import telran.pulse.monitoring.dto.SensorJump;

@SpringBootApplication
public class JumpsNotifierApplication {
static Logger LOG = LoggerFactory.getLogger(JumpsNotifierApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JumpsNotifierApplication.class, args);

	}
	@Bean
	Consumer<SensorJump> criticalJumpsConsumer() {
		return this::jumpsProcessing;
	}
	void jumpsProcessing(SensorJump sensorJump) {
		LOG.trace("received sensor id {} previous value {} current value {}",
				sensorJump.sensorId, sensorJump.previousValue, sensorJump.currentValue);
	}

}