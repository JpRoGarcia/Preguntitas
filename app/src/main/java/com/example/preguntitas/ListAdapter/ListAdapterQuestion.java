package com.example.preguntitas.ListAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.preguntitas.QuestionR;
import com.example.preguntitas.QuestionU;
import com.example.preguntitas.R;
import com.example.preguntitas.database.CRUDQuestion;
import com.example.preguntitas.object.Question;

import java.util.List;

public class ListAdapterQuestion extends RecyclerView.Adapter<ListAdapterQuestion.ViewHolder> {
    private List<Question> mQuestion;
    private LayoutInflater mInflater;
    private Context ctx;

    public ListAdapterQuestion(List<Question> mQuestion, Context ctx) {
        this.mQuestion = mQuestion;
        this.mInflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @Override
    public int getItemCount() {
        return mQuestion.size();
    }

    @Override
    public ListAdapterQuestion.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_question, null);
        return new ListAdapterQuestion.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mQuestion.get(position));
    }

    public void setItems(List<Question> items) { mQuestion = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView CPregunta, COpUno, COpDos, COpTre;

        ViewHolder(View itemView){
            super(itemView);
            CPregunta = itemView.findViewById(R.id.CPregunta);
            COpUno = itemView.findViewById(R.id.COpUno);
            COpDos = itemView.findViewById(R.id.COpDos);
            COpTre = itemView.findViewById(R.id.COpTre);

        }

        void bindData(final Question item) {

            CPregunta.setText(item.getPregunta());
            COpUno.setText(item.getCorrecta());
            COpDos.setText(item.getOpcionUno());
            COpTre.setText(item.getOpcionDos());

            itemView.findViewById(R.id.CDelete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CRUDQuestion objDB = new CRUDQuestion(ctx);
                    objDB.DeleteQuestion(item.getId());
                    Toast.makeText(ctx, "Pregunta Eliminada", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(ctx, QuestionR.class);
                    ctx.startActivity(I);
                }
            });

            itemView.findViewById(R.id.CEdit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent I = new Intent(ctx, QuestionU.class);
                    I.putExtra("id", item.getId());
                    I.putExtra("Q", item.getPregunta());
                    I.putExtra("C", item.getCorrecta());
                    I.putExtra("Opc1", item.getOpcionUno());
                    I.putExtra("Opc2", item.getOpcionDos());
                    I.putExtra("P", item.getPuntuacion());
                    ctx.startActivity(I);
                }
            });
        }
    }

}
