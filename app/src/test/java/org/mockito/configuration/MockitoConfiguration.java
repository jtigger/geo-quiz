package org.mockito.configuration;

import org.mockito.Answers;
import org.mockito.stubbing.Answer;

import static org.mockito.Answers.RETURNS_SMART_NULLS;

public class MockitoConfiguration extends DefaultMockitoConfiguration {
    @Override
    public Answer<Object> getDefaultAnswer() {
        return RETURNS_SMART_NULLS.get();
    }
}
