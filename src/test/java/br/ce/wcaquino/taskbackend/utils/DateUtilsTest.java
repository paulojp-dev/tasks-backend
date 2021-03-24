package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate date = LocalDate.of(2030, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(date);
        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarFalseParaDatasPassadas() {
        LocalDate date = LocalDate.of(2010, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(date);
        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarTrueParaDataAtual() {
        LocalDate date = LocalDate.now();
        boolean result = DateUtils.isEqualOrFutureDate(date);
        Assert.assertTrue(result);
    }
}
