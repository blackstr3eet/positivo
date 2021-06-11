package br.com.positivo.exam

import br.com.positivo.bitwise.Bitwise
import br.com.positivo.bitwise.Bitwise.or
import br.com.positivo.bitwise.Bitwise.xor
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BitwiseTest {

    @Test
    fun methodOrWithInputIsInvalid() {
        Assert.assertEquals(or("HG", "FF"), Bitwise.MESSAGE_ERROR_INPUT)
    }

    @Test
    fun methodOrWithInputIsValid() {
        Assert.assertNotEquals(or("65", "ac"), Bitwise.MESSAGE_ERROR_INPUT)
    }

    @Test
    fun methodOrReturnValueCorrect() {
        Assert.assertEquals(or("FF", "FAA"), "FFF")
    }

    @Test
    fun methodOrReturnValueCorrectInputUpperCase() {
        Assert.assertEquals(or("B12", "AF"), "BBF")
    }

    @Test
    fun methodOrReturnValueCorrectInputLowerCase() {
        Assert.assertEquals(or("b12", "af"), "BBF")
    }

    @Test
    fun methodOrReturnValueCorrectInputMixedCase() {
        Assert.assertEquals(or("b12", "AF"), "BBF")
    }

    @Test
    fun methodXorWithInputIsInvalid() {
        Assert.assertEquals(xor("HG", "FF"), Bitwise.MESSAGE_ERROR_INPUT)
    }

    @Test
    fun methodXorWithInputIsValid() {
        Assert.assertNotEquals(xor("65", "ac"), Bitwise.MESSAGE_ERROR_INPUT)
    }

    @Test
    fun methodXorReturnValueCorrect() {
        Assert.assertEquals(xor("FF", "FAA"), "F55")
    }

    @Test
    fun methodXorReturnValueCorrectInputUpperCase() {
        Assert.assertEquals(xor("B12", "AF"), "BBD")
    }

    @Test
    fun methodXorReturnValueCorrectInputLowerCase() {
        Assert.assertEquals(xor("b12", "af"), "BBD")
    }

    @Test
    fun methodXorReturnValueCorrectInputMixedCase() {
        Assert.assertEquals(xor("b12", "AF"), "BBD")
    }
}