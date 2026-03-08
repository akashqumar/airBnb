package com.airbnb.clone.infrastructure.config;

import com.airbnb.clone.application.port.NotificationPort;
import com.airbnb.clone.domain.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    private static final Logger log = LoggerFactory.getLogger(NotificationConfig.class);

    @Bean
    public NotificationPort notificationPort() {
        return new ReservationLoggingNotifier();
    }

    static class ReservationLoggingNotifier implements NotificationPort {
        @Override
        public void sendReservationCreated(Reservation reservation) {
            log.info("Reservation created event published for reservationId={}", reservation.id());
        }
    }
}
