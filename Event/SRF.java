//Student registration form(Ex 9)
import java.awt.*;
import java.awt.event.*;

class SRF {
    public static void main(String args[]) {

        // Frame
        Frame frame = new Frame("Student Response Form");
        frame.setSize(1000,800);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLayout(null);
        //frame.setBackground(Color.GRAY);

        // Title of the Form
        Label title = new Label("Student Response Form");
        title.setBounds(309, 50, 800, 30);
       // Font font = new Font("Arial", Font.BOLD, 30);
        //title.setFont(font);
        frame.add(title);

        // Font for the rest of the form
       // Font f = new Font("Calibri", Font.PLAIN, 17);

        // Registration number
        Label rnol = new Label("Registration no. ");
        rnol.setBounds(10, 150, 120, 30);
        //rnol.setFont(f);
        frame.add(rnol);
        TextField rno = new TextField();
		//rno.setFont(f);
        rno.setBounds(140, 150, 210, 30);
        frame.add(rno);

        // Name
        Label namel = new Label("Name ");
        namel.setBounds(10, 200, 120, 30);
        //namel.setFont(f);
        frame.add(namel);
        TextField name = new TextField();
       // name.setFont(f);
		name.setBounds(140, 200, 210, 30);
        frame.add(name);

        // Gender
        Label genderl = new Label("Gender ");
        genderl.setBounds(10, 250, 120, 30);
        //genderl.setFont(f);
        frame.add(genderl);
        CheckboxGroup gender = new CheckboxGroup();
        Checkbox male = new Checkbox("Male", gender, false);
        Checkbox female = new Checkbox("Female", gender, false);
        //male.setFont(f);
        //female.setFont(f);
        male.setBounds(140, 250, 90, 30);
        female.setBounds(280, 250, 90, 30);
        frame.add(male);
        frame.add(female);

        // Degree
        Label degreel = new Label("Degree ");
        degreel.setBounds(10, 300, 120, 30);
        //degreel.setFont(f);
        frame.add(degreel);
        Choice degree = new Choice();
        degree.add("B.Tech.");
        degree.add("B.Sc.");
        degree.add("B.Com.");
        degree.setBounds(140, 300, 120, 30);
        //degree.setFont(f);
        frame.add(degree);

        // Branch
        Label branchl = new Label("Branch ");
        branchl.setBounds(10, 350, 120, 30);
        //branchl.setFont(f);
        frame.add(branchl);
        Choice branch = new Choice();
       // branch.add("CSE");
        //branch.add("ECE");
		
		
        degree.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                //branch.removeAll();
                if (degree.getSelectedItem().equals("B.Tech.")) {
                    branch.add("CSE");
                    branch.add("ECE");
                }
                if (degree.getSelectedItem().equals("B.Sc.")) {
                    branch.add("Physics");
                    branch.add("Chemistry");
                    branch.add("Biology");
                }
                if (degree.getSelectedItem().equals("B.Com.")) {
                    branch.add("Accounting");
                    branch.add("Marketing");
                    branch.add("Stock Market");
                }
            }
        });
       // branch.setFont(f);
        branch.setBounds(140, 350, 120, 30);
        frame.add(branch);

        // Year of Study
        Label yosl = new Label("Year of Study ");
        yosl.setBounds(10, 400, 120, 30);
        //yosl.setFont(f);
        frame.add(yosl);
        Choice yos = new Choice();
        //yos.add("1");
        //yos.add("2");
        //yos.add("3");
        //yos.add("4");
        degree.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               // yos.removeAll();
                if (degree.getSelectedItem().equals("B.Tech.")) {
                    yos.add("1");
                    yos.add("2");
                    yos.add("3");
                    yos.add("4");
                }
                if (degree.getSelectedItem().equals("B.Sc.")) {
                    yos.add("1");
                    yos.add("2");
                    yos.add("3");
                }
                if (degree.getSelectedItem().equals("B.Com.")) {
                    yos.add("1");
                    yos.add("2");
                    yos.add("3");
                }
            }
        });
        yos.setBounds(140, 400, 120, 30);
        //yos.setFont(f);
        frame.add(yos);

        // Date of Birth
        Choice dobd = new Choice();
        Label dobl = new Label("Date of Birth ");
        dobl.setBounds(10, 450, 120, 30);
        //dobl.setFont(f);
        frame.add(dobl);
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Choice dobm = new Choice();
        for (String mon : month)
            dobm.add(mon);
        //dobm.setFont(f);
        dobm.setBounds(210, 450, 60, 30);
        frame.add(dobm);

        Choice doby = new Choice();
        for (int i = 1998; i < 2023; i++)
            doby.add(Integer.toString(i));
        doby.setBounds(280, 450, 60, 30);
        //doby.setFont(f);
        frame.add(doby);
		
        doby.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int leap =0;
				if(Integer.parseInt(doby.getSelectedItem()) % 4 == 0 && (Integer.parseInt(doby.getSelectedItem()) % 100 != 0 || Integer.parseInt(doby.getSelectedItem()) % 400 == 0))
				
			leap = 1;
				else leap = 0;
				if (leap == 1 && dobm.getSelectedItem().equals("Feb")) {
                    dobd.add("29");
                }
				if(leap == 0 && dobm.getSelectedItem().equals("Feb")){
					dobd.removeAll();
					for(int i=1;i<29;i++)
						dobd.add(Integer.toString(i));
				}
				
				
            }
        });

        String[] month31 = {"Jan", "Mar", "May", "Jul", "Aug", "Oct", "Dec"};
        String[] month30 = {"Apr", "Jun", "Sep", "Nov"};
        for (int i = 1; i < 32; i++)
            dobd.add(Integer.toString(i));
        dobm.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                dobd.removeAll();
                for (String m : month31) {
                    if (m.equals(dobm.getSelectedItem())) {
                        for (int i = 1; i < 32; i++)
                            dobd.add(Integer.toString(i));
                    }
                }
                for (String m : month30) {
                    if (m.equals(dobm.getSelectedItem())) {
                        for (int i = 1; i < 31; i++)
                            dobd.add(Integer.toString(i));
                    }
                }
                if (dobm.getSelectedItem().equals("Feb")) {
                    for (int i = 1; i < 29; i++)
                        dobd.add(Integer.toString(i));
                }

                if (Integer.parseInt(doby.getSelectedItem()) % 4 == 0 && Integer.parseInt(doby.getSelectedItem()) % 100 != 0
                        && dobm.getSelectedItem().equals("Feb")) {
                    dobd.add("29");
                }
            }
        });

        //dobd.setFont(f);
        dobd.setBounds(140, 450, 60, 30);
        frame.add(dobd);
		
		//Address
		Label addrl = new Label("Address");
		//addrl.setFont(f);
		addrl.setBounds(560,150,120,30);
		frame.add(addrl);
		TextArea addr = new TextArea();
		//addr.setFont(f);
		addr.setBounds(690,150,250,165);
		frame.add(addr);
		
		//Email ID
		Label emaill = new Label("Email ");
		//emaill.setFont(f);
		emaill.setBounds(560,350,120,30);
		frame.add(emaill);
		TextField email = new TextField();
		//email.setFont(f);
		email.setBounds(690,350,210,30);
		frame.add(email);
		
		//Hobby
		Label hobbyl = new Label("Hobby");
		//hobbyl.setFont(f);
		hobbyl.setBounds(560,400,120,30);
		frame.add(hobbyl);
		Checkbox games = new Checkbox();
		Checkbox stamp = new Checkbox();
		Checkbox others = new Checkbox();
		Label gamesl = new Label("Games");
		Label stampl = new Label("Stamp");
		Label othersl = new Label("Others");
		games.setBounds(690,400, 20, 30);
		stamp.setBounds(780,400, 20, 30);
		others.setBounds(865, 400, 20, 30);
		gamesl.setBounds(710, 400, 60, 30);
		stampl.setBounds(800, 400, 60, 30);
		othersl.setBounds(885, 400, 60, 30);
		//gamesl.setFont(f);
		//othersl.setFont(f);
		//stampl.setFont(f);
		frame.add(games);
		frame.add(stamp);
		frame.add(others);

		frame.add(gamesl);
		frame.add(stampl);
		frame.add(othersl);
		
		//Extra Curricular
		Label ecl = new Label("Extra Curricular");
		//ecl.setFont(f);
		ecl.setBounds(560,450,120,30);
		frame.add(ecl);
		List ec = new List(5,false);
		ec.add("Football");
		ec.add("Cricket");
		ec.add("Chess");
		ec.add("Tennis");
		ec.add("Others");
		//ec.setFont(f);
		ec.setBounds(690,450,100,70);
		frame.add(ec);
		
		//Final text and submit buttond
		TextArea lastt = new TextArea();
        //lastt.setFont(f);
        lastt.setBounds(5, 600,990,190 );
		
				
		Button submitButton = new Button("Submit");
        //submitButton.setFont(f);
        submitButton.setBounds(430, 530, 120, 30);
        frame.add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String last = "Your Details:\n"; 
        String rnot = rno.getText();
        String namet = name.getText();

        String degreet = degree.getSelectedItem();
        String brancht = branch.getSelectedItem();
        String yost = yos.getSelectedItem();
       String dobt = dobd.getSelectedItem() + "/" + dobm.getSelectedItem() + "/" + doby.getSelectedItem();

        String addrt = addr.getText();
        String emailt = email.getText();
        boolean gamest = games.getState();
        boolean stampt = stamp.getState();
        boolean otherst = others.getState();
        String ect = ec.getSelectedItem();

        if (rnot.length() != 9) {
            last += "Registration Number should have only 9 digits. \n";
            lastt.setText(last);
			return;
        } else {
            last += "My registration number is " + rnot + ". \n";
        }
if (namet.length() == 0) {
    last += "Name should not be blank. \n";
    lastt.setText(last);
    return;
}
else {
            last += "My name is " + namet + ". \n";
        }

        last += "I was born on " + dobt + ".\n";
		
        if (male.getState() && !female.getState()) {
            last += "My gender is male.\n";
        } else if (!male.getState() && female.getState()) {
            last += "My gender is female.\n";
        } else {
            last += "Select a gender.\n";
			lastt.setText(last);
            return;
        }

        last += "I am pursuing " + degreet + " in " + brancht + ". \n";
        last += "I am in year " + yost + ". \n";
		
        if (!gamest && !stampt && !otherst) {
            last += "Select at least one hobby.";
            lastt.setText(last);
			return;
        }

        if (gamest) {
            last += "Playing games is my hobby.\n";
        }
        if (stampt) {
            last += "Collecting stamps is my hobby.\n";
        }
        if (otherst) {
            last += "I spend my time productively when I am free. \n";
        }

        if (ect == null) {
            last += "Select at least one extra-curricular activity. \n";
            lastt.setText(last);
			return;
        } else {
            last += "I like to play " + ect + ". \n";
        }

        if (addrt.equals("")) {
            last += "Enter your address.\n";
            lastt.setText(last);
			return;
        } else {
            last += "My address is " + addrt + ".\n";
        }

        if (emailt == null || emailt.equals("")) {
            last += "Enter your email.\n";
            lastt.setText(last);
			return;
        } else {
            last += "You can contact me using " + emailt + ".\n";
        }
		lastt.setText(last);
		frame.repaint();
		
 }
});


		frame.add(lastt);

		
		
		
		

    }
}