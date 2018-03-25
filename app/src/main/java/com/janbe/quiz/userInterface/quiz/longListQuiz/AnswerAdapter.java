package com.janbe.quiz.userInterface.quiz.longListQuiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.janbe.quiz.R;
import com.janbe.quiz.domain.answer.Answer;

import java.util.List;

public class AnswerAdapter extends ArrayAdapter<Answer> {

    // Constructor is package private (no identifier)
    AnswerAdapter(Context context, int resource, List<Answer> answers) {
        super(context, resource, answers);

    }

    // Returns a ListView item
    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {

            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.row_long_list_answers,
                    parent,
                    false
            );

        }

        Answer answer = getItem(position);

        if (answer != null) {

            TextView answerText = view.findViewById(R.id.rowAnswerText);
            answerText.setText(answer.getAnswer());

        }

        return view;
    }

}
