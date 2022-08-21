import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class ExamGraderTest {
    ExamGrader.ExamQuestion q1 = new ExamGrader.ExamQuestion(5.5, null);
    ExamGrader.ExamQuestion q2 = new ExamGrader.ExamQuestion(4.7, q1);
    ExamGrader.ExamQuestion q3 = new ExamGrader.ExamQuestion(4.0, q2);

    @Test
    public void testWithOneQuestion() {
        int examGradeRoundedDown = ExamGrader.calculateExamGrade(q1, (sum)-> (int)Math.floor(sum) );
        assertEquals(5, examGradeRoundedDown);
        int examGradeRoundedUp = ExamGrader.calculateExamGrade(q1, (sum)-> (int)Math.ceil(sum) );
        assertEquals(6, examGradeRoundedUp);
    }

    @Test
    public void testWithTwoQuestions() {
        // calculate the exam grade by rounding down
        int examGradeRoundedDown = ExamGrader.calculateExamGrade(q2, (sum)-> (int)Math.floor(sum) );
        assertEquals(10, examGradeRoundedDown);

        // calculate the exam grade by rounding up
        int examGradeRoundedUp = ExamGrader.calculateExamGrade(q2, (sum)-> (int)Math.ceil(sum) );
        assertEquals(11, examGradeRoundedUp);
    }


    @Test
    public void testTwoShortExams() throws ExecutionException, InterruptedException {
        // The first exam has questions q1 and q2.
        // The second exam has questions q1, q2, and q3.

        int[] resultsRoundedDown = ExamGrader.gradeExams(q2, q3, (sum)-> (int)Math.floor(sum) );
        assertEquals(2, resultsRoundedDown.length);
        assertEquals( resultsRoundedDown[0], 10);  // result of first exam
        assertEquals( resultsRoundedDown[1], 14);  // result of second exam

        int[] resultsRoundedUp = ExamGrader.gradeExams(q2, q3, (sum)-> (int)Math.ceil(sum) );
        assertEquals(2, resultsRoundedUp.length);
        assertEquals( resultsRoundedUp[0], 11);
        assertEquals( resultsRoundedUp[1], 15);
    }

    @Test
    public void testDelayedExams() throws ExecutionException, InterruptedException {
        // The first exam has questions q1 and q2.
        // The second exam has questions q1, q2, and q3.
        Random rng = new Random();
        int[] resultsRoundedUp = ExamGrader.gradeExams(q2, q3, (sum)-> {
            try {
                // this exams need some time to grade them...
                Thread.sleep(300+rng.nextInt(500));
            }
            catch(InterruptedException e) {
            }
            return (int)Math.ceil(sum);
        } );
        assertEquals(2, resultsRoundedUp.length);
        assertEquals( resultsRoundedUp[0], 11);
        assertEquals( resultsRoundedUp[1], 15);
    }
}
