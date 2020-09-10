package com.nodamu.cargotracker.booking.application;

import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.application.services.commandservices.BookCargoCommandService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


import java.util.UUID;

/**
 * @author profnick
 * 9/8/20
 **/
public class BookCargoServiceUnitTest {
    public final CargoRepository cargoRepository  = Mockito.mock(CargoRepository.class);

    public final BookCargoCommandService service = new BookCargoCommandService(cargoRepository);

    @Test
    void shouldReturnCargoId(){
        //Given
        BookCargoCommand command = new BookCargoCommand(
                100,
                "NGA",
                "GHA",
                java.sql.Date.valueOf("2020-09-07")
        );

        //When
        BookingId id = service.bookCargo(command);

        //Then
        assertThat(id.getBookingId()).isNotNull();
        assertThat(id.getBookingId()).isEqualTo(command.getBookingId());
    }

}
