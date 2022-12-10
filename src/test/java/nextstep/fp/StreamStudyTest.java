package nextstep.fp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countWords() throws Exception {
        long result = StreamStudy.countWords();
        System.out.println("result : " + result);
    }

    @Test
    public void printLongestWordTop100() throws Exception {
        // [O]단어의 길이가 12자를 초과하는 단어를 추출
        // [O]12자가 넘는 단어중 길이가 긴 순서로 / 100개의 단어 추출
        // [O]단어 중복 허용X, [O]모든 단어는 소문자로 출력
        List<String> strings = StreamStudy.printLongestWordTop100();
        Assertions.assertThat(strings.size()).isEqualTo(100); // 100개 인지?
        for (String index : strings) {
            Assertions.assertThat(index.length()).isGreaterThan(12); // 12자 초과
            Assertions.assertThat(strings).containsOnlyOnce(index); // 중복확인
            Assertions.assertThat(index).isLowerCase(); // 소문자 인지
        }
    }

    @Test
    public void map() throws Exception {
        List<Integer> doubleNumbers = StreamStudy.doubleNumbers(numbers);
        doubleNumbers.forEach(System.out::println);
    }

    @Test
    public void sumAll() throws Exception {
        long sum = StreamStudy.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumOverThreeAndDouble() throws Exception {
        numbers = Arrays.asList(3, 1, 6, 2, 4, 8);
        long sum = StreamStudy.sumOverThreeAndDouble(numbers);
        assertThat(sum).isEqualTo(36);
    }
}
