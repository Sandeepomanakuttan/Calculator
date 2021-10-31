package com.example.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var btn0:Button
    lateinit var btn:Button
    lateinit var btn00:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var btnClear:Button
    lateinit var btnper:Button
    lateinit var btndiv:Button
    lateinit var btnsub:Button
    lateinit var btnmul:Button
    lateinit var btnback:Button
    lateinit var btnplus:Button
    lateinit var btnequal:Button
    lateinit var input:EditText
    lateinit var result:EditText

    var check=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn00=findViewById(R.id.btn2Zero)
        btn=findViewById(R.id.btn)
        btn0=findViewById(R.id.btn0)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)
        btnequal=findViewById(R.id.btnequal)
        btnplus=findViewById(R.id.btnplus)
        btnback=findViewById(R.id.btnback)
        btnmul=findViewById(R.id.btnmul)
        btnsub=findViewById(R.id.btnsub)
        btndiv=findViewById(R.id.btndiv)
        btnper=findViewById(R.id.btnper)
        btnClear=findViewById(R.id.btnClear)
        input=findViewById(R.id.input)
        result=findViewById(R.id.result)
        input.movementMethod=ScrollingMovementMethod()
        input.setActivated(true)
        input.setPressed(true)
        
        var text:String
        btn0.setOnClickListener{
            text=input.text.toString()+"0"
            input.setText(text)
            resultfun(text)
        }
        btn1.setOnClickListener{
            text=input.text.toString()+"1"
            input.setText(text)
            resultfun(text)
        }
        btn2.setOnClickListener{
            text=input.text.toString()+"2"
            input.setText(text)
            resultfun(text)
        }
        btn3.setOnClickListener{
            text=input.text.toString()+"3"
            input.setText(text)
            resultfun(text)
        }
        btn4.setOnClickListener{
            text=input.text.toString()+"4"
            input.setText(text)
            resultfun(text)
        }
        btn5.setOnClickListener{
            text=input.text.toString()+"5"
            input.setText(text)
            resultfun(text)
        }
        btn6.setOnClickListener{
            text=input.text.toString()+"6"
            input.setText(text)
            resultfun(text)
        }
        btn7.setOnClickListener{
            text=input.text.toString()+"7"
            input.setText(text)
            resultfun(text)
        }
        btn8.setOnClickListener{
            text=input.text.toString()+"8"
            input.setText(text)
            resultfun(text)
        }
        btn9.setOnClickListener{
            text=input.text.toString()+"9"
            input.setText(text)
            resultfun(text)
        }
        btn00.setOnClickListener{
            text=input.text.toString()+"00"
            input.setText(text)
            resultfun(text)
        }
        btn.setOnClickListener{
            text=input.text.toString()+"."
            input.setText(text)
            resultfun(text)
        }
        btnClear.setOnClickListener{
            input.setText(null)
            result.setText(null)
        }
        btnback.setOnClickListener{
            var backspace:String?=null
            if (input.text.length>1){
                val stringbuilder:StringBuilder= StringBuilder(input.text)
                var find=input.text.toString()
                var find1=find.last()
                if (find1.equals("+")||find1.equals("-")||find1.equals("/")||find1.equals("*")){
                    check-=check
                }
                stringbuilder.deleteCharAt(input.text.length-1)
                backspace=stringbuilder.toString()
                input.setText(backspace)
                resultfun(backspace)
            }
            else if(input.text.length==1){
                input.setText(null)
            }
        }
        btnper.setOnClickListener{
            text=input.text.toString()+"%"
            input.setText(text)
            check+=check
        }
        btnplus.setOnClickListener{
            text=input.text.toString()+"+"
            input.setText(text)
            check+=1
        }
        btnsub.setOnClickListener{
            text=input.text.toString()+"-"
            input.setText(text)
            check+=1
        }
        btnmul.setOnClickListener{
            text=input.text.toString()+"*"
            check+=1
            input.setText(text)
        }
        btndiv.setOnClickListener{
            text=input.text.toString()+"/"
            input.setText(text)
            check+=1
        }
        btnequal.setOnClickListener{
            text=input.text.toString()
            if(text.length==0){
                input.setText(null)
                Toast.makeText(this, "Could you perform some Operation", Toast.LENGTH_SHORT).show()
            }else {
                resultfun(text)
            }
        }


    }

    private fun resultfun(text: String) {
            val engine: ScriptEngine =ScriptEngineManager().getEngineByName("rhino")
        try{
            val ru:Any=engine.eval(text)
            val mainr=ru.toString()
            if (check==0){
                result.setText(null)
            }else{
                result.setText(mainr)
                input.setText(mainr)
            }

        }catch (e:ScriptException){
            Log.d("TAG","ERROR")
        }
    }
}