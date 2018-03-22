package com.janbe.quiz.userInterface.quiz.longListQuiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.janbe.quiz.R;
import com.janbe.quiz.domain.answer.Answer;

import java.util.List;

/**
 * Created by janbe on 22-Mar-18.
 */

public class AnswerAdapter extends ArrayAdapter<Answer> {

    public AnswerAdapter(Context context, int resource, List<Answer> answers) {
        super(context, resource, answers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {

            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.row_long_list_answers,
                    parent,
                    false
            );

        }

        Answer answer = getItem(position);

        TextView answerText = (TextView) view.findViewById(R.id.rowAnswerText);
        answerText.setText(answer.getAnswer());

        return view;
    }

}
