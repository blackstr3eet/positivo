package br.com.positivo.exam

import br.com.positivo.bitwise.Bitwise
import br.com.positivo.bitwise.Bitwise.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Bitwise::class, BitwiseTest::class)
open class BitwiseTest {

    @Before
    fun setUp() {
//        mockStatic(Bitwise::class.java)

//        `when`(or(anyString(), anyString())).thenReturn("")
//        `when`(xor(anyString(), anyString())).thenReturn("")
    }

    @Test
    fun initTest() {
//        Assert.assertEquals(or("FA", "FF"), "CF");
    }
}