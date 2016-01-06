package thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScannerTest {

    @Test
    public void should_get_next_given_normal_string() {

        // given
        Scanner scanner = new Scanner("2+1");

        // then
        assertThat(scanner.getNext(),is('2'));
        assertThat(scanner.getNext(),is('+'));
        assertThat(scanner.getNext(),is('1'));
        assertThat(scanner.getNext(),is(Scanner.END));
        assertThat(scanner.getNext(),is(Scanner.END));
    }

    @Test
    public void should_ignore_blank() {
        // given
        Scanner scanner = new Scanner("2 + 1");

        // then
        assertThat(scanner.getNext(),is('2'));
        assertThat(scanner.getNext(),is('+'));
        assertThat(scanner.getNext(),is('1'));
        assertThat(scanner.getNext(),is(Scanner.END));
    }
}