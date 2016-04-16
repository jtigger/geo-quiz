package com.infosysengr.geoquiz;

import com.android.internal.util.Predicate;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InMemoryQuestionBank implements QuestionBank {
    private List<Question> allQuestions = new ArrayList<>();
    private List<Boolean> answers = Arrays.asList(true, false, false, true, true);
    private Iterator<Question> allQuestionsItr;

    public InMemoryQuestionBank() {
        final Class resources = R.string.class;
        final List<Integer> resourceIds = new ArrayList<>();
        for (int idx = 0; idx < answers.size(); idx++) {
            try {
                resourceIds.add(resources.getField("question_" + idx).getInt(resources));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (int idx = 0; idx < resourceIds.size(); idx++) {
            allQuestions.add(new Question(resourceIds.get(idx), answers.get(idx)));
        }
        reset();
    }

    @Override
    public Question nextQuestion() {
        if (!allQuestionsItr.hasNext()) {
            reset();
        }
        return allQuestionsItr.next();
    }

    private void reset() {
        allQuestionsItr = allQuestions.iterator();
    }

}
