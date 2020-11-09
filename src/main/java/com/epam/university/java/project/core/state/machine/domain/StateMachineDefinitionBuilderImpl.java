package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineDefinitionBuilderImpl implements
        StateMachineDefinitionBuilder<BookStatus, BookEvent> {

    StateMachineDefinition<BookStatus, BookEvent> def = new StateMachineDefinitionImpl();

    /**
     * Build state machine definition.
     *
     * @return built definition
     */
    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        return def;
    }

    /**
     * Add state to definition.
     *
     * @param from   from state
     * @param to     to state
     * @param on     event
     * @param method method to call
     * @return builder
     */
    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from,
            BookStatus to,
            BookEvent on,
            String method
    ) {
        StateMachineState<BookStatus, BookEvent> state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        state.setMethodToCall(method);
        def.addState(state);
        return this;
    }

    /**
     * Add state to definition.
     *
     * @param from from state
     * @param to   to state
     * @param on   event
     * @return builder
     */
    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from,
            BookStatus to,
            BookEvent on
    ) {
        StateMachineState<BookStatus, BookEvent> state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        def.addState(state);
        return this;
    }
}
