import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Iterator;
class InputMissingException extends Exception
{
    InputMissingException(String str)
    {
        super(str);
    }
}
class input
{
    String code,name,q,q1,n,t,d;
    input(String code,String name,String d,String q,String q1,String t,String n)
    {
        this.code = code;
        this.name = name;
        this.d = d;
        this.q = q;
        this.q1 = q1;
        this.t = t;
        this.n = n;
    }
}
class FeedBack extends JFrame
{
    JLabel lcourse,lname,ldata,lquestion,lqp,ltime,lnat,end;
    JTextField jcourse,jname;
    JRadioButton data,jdata,jquestion,question,jgqp,gqp,qp,jsuff,suff,jnat,jna,nat;
    ButtonGroup bdata,bquestion,bqp,btime,bnat;
    JButton Add,Display;
    JTextArea error;
    String code,name,q,q1,n,t,d;
    JScrollPane j;
    ArrayList<input> a=new ArrayList<>();
    FeedBack()
    {
        setTitle("SASTRA University");
        lcourse=new JLabel("Course Code ");
        lcourse.setBounds(50,50,120,50);
        add(lcourse);
        jcourse=new JTextField();
        jcourse.setBounds(180,50,70,30);
        add(jcourse);
        lname=new JLabel("Course Name ");
        lname.setBounds(50,120,120,30);
        add(lname);
        jname=new JTextField();
        jname.setBounds(180,120,200,30);
        add(jname);
        ldata=new JLabel("Whether all the required data are given ?");
        ldata.setBounds(50,190,400,50);
        add(ldata);
        data=new JRadioButton("Yes");
        data.setBounds(70,240,50,50);
        jdata=new JRadioButton("No");
        jdata.setBounds(130,240,50,50);
        bdata=new ButtonGroup();
        bdata.add(data);
        bdata.add(jdata);
        add(data);
        add(jdata);
        lquestion=new JLabel("Is any question from out of Syllabus ?");
        lquestion.setBounds(50,300,400,50);
        add(lquestion);
        jquestion=new JRadioButton("Yes");
        jquestion.setBounds(70,370,50,50);
        add(jquestion);
        question=new JRadioButton("No");
        question.setBounds(130,370,50,50);
        add(question);
        bquestion=new ButtonGroup();
        bquestion.add(jquestion);
        bquestion.add(question);
        lqp=new JLabel("Standard of Question in QP ");
        lqp.setBounds(50,420,400,50);
        add(lqp);
        jgqp=new JRadioButton("Good");
        jgqp.setBounds(70,470,70,50);
        add(jgqp);
        gqp=new JRadioButton("Medium");
        gqp.setBounds(150,470,90,50);
        add(gqp);
        qp=new JRadioButton("Low");
        qp.setBounds(250,470,90,50);
        add(qp);
        bqp=new ButtonGroup();
        bqp.add(jgqp);
        bqp.add(gqp);
        bqp.add(qp);
        ltime=new JLabel("Is time alloted sufficient ?");
        ltime.setBounds(50,560,400,50);
        add(ltime);
        jsuff=new JRadioButton("Sufficient");
        jsuff.setBounds(70,620,120,50);
        add(jsuff);
        suff=new JRadioButton("Insufficient");
        suff.setBounds(210,620,130,50);
        add(suff);
        btime=new ButtonGroup();
        btime.add(jsuff);
        btime.add(suff);
        lnat=new JLabel("Nature of QP");
        lnat.setBounds(50,690,300,50);
        add(lnat);
        jnat=new JRadioButton("Tough");
        jnat.setBounds(70,750,70,50);
        add(jnat);
        jna=new JRadioButton("Normal");
        jna.setBounds(150,750,70,50);
        add(jna);
        nat=new JRadioButton("Easy");
        nat.setBounds(230,750,70,50);
        add(nat);
        bnat=new ButtonGroup();
        bnat.add(jnat);
        bnat.add(jna);
        bnat.add(nat);
        Add=new JButton("Add");
        Add.setBounds(90,800,80,40);
        add(Add);
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String code=jcourse.getText();
                if(code.isEmpty())
                {
                    try
                    {
                        throw new InputMissingException("Enter Valid Course Code");
                    }
                    catch(InputMissingException x)
                    {
                        error.setText("Enter Valid Course Code");
                    }
                }
                String name=jname.getText();
                String d=data.isSelected()?"Yes":"No";
                String q=jquestion.isSelected()?"YES":"NO";
                String q1=jgqp.isSelected()?"GOOD":(gqp.isSelected()?"MEDIUM":"EASY");
                String t=jsuff.isSelected()?"SUFFICIENT":"INSUFFICIENT";
                String n=jnat.isSelected()?"TOUGH":(jna.isSelected()?"NORMAL":"LOW");
                a.add(new input(code,name,d,q,q1,t,n));
                jcourse.setText(" ");
                jname.setText(" ");
                data.setSelected(false);
                jquestion.setSelected(false);
                jgqp.setSelected(false);
                jsuff.setSelected(false);
                jnat.setSelected(false);
            }
        });
        error = new JTextArea();
        j=new JScrollPane(error);
        j.setBounds(550,200,300,250);
        add(j);
        Display=new JButton("Display");
        Display.setBounds(170,800,80,40);
        add(Display);
        end=new JLabel("END !");
        end.setBounds(500,1000,50,60);
        add(end);
        Display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1)
            {
                String line=" ";
                Iterator itr=a.iterator();
                while(itr.hasNext())
                {
                    input f=(input)itr.next();
                    line+="Course Code :"+f.code+"\nCourse Name :"+f.name;
                    line+="\nWhether all the required data are given :"+f.d;
                    line+="\nIs any question from out of Syllabus :"+f.q;
                    line+="\nStandard of Question in QP :"+f.q1;
                    line+="\nIs time alloted sufficient :"+f.t;
                    line+="\nNature of QP : "+f.n;
                    error.setText(line);

                }
            }
        });
        
        setSize(1100,1000);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        new FeedBack();
    }
}