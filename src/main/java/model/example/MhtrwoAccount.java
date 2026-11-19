package model.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import tech.ailef.snapadmin.external.annotations.DisplayFormat;
import tech.ailef.snapadmin.external.annotations.Filterable;
import validation.IbanConstraint;

import static validation.GreekValidationMessages.BETWEEN_FOURTEEN_AND_THIRTY_ONE_DIGITS_LENGTH_MESSAGE;
import static validation.GreekValidationMessages.NOT_NULL_MESSAGE;

@Data
@Entity
@Getter
@Table(name = "MHTRWO_ACCOUNT", schema = "__SCHEMA_PLACEHOLDER__")
public class MhtrwoAccount {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mhtrwo_account_generator")
    @SequenceGenerator(
            name = "mhtrwo_account_generator",
            sequenceName = "MHTRWO_ACCOUNT_SEQ",
            allocationSize = 1,
            schema = "__SCHEMA_PLACEHOLDER__"
    )
    private long ID;

    @ManyToOne
    @Filterable
    @NotNull(message = NOT_NULL_MESSAGE)
    @JoinColumn(name = "MHTRWO_ID", referencedColumnName = "ID", nullable = false)
    private Mhtrwo mhtrwo;

    @Filterable
    @IbanConstraint
    @Column(name = "IBAN", unique = true)
    @Size(min = 14, max = 31, message = BETWEEN_FOURTEEN_AND_THIRTY_ONE_DIGITS_LENGTH_MESSAGE)
    private String iban;

    @Filterable
    @Column(name = "BALANCE")
    @DisplayFormat(format = "€%.2f")
    private Double balance;

}
