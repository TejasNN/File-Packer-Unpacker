import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextPage extends Template implements ActionListener
{
    JLabel label;
    JButton Pack, Unpack;

    NextPage(String value)
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        label = new JLabel("Welcome: "+value);
        Dimension size = label.getPreferredSize();
        label.setBounds(40,50,size.width + 60, size.height);
        label.setFont(new Font("Century",Font.BOLD, 17));
        label.setForeground(Color.blue);

        Pack = new JButton("Pack Files");
        Dimension bsize = Pack.getPreferredSize();
        Pack.setBounds(100,100,bsize.width + 60, bsize.height);
        Pack.addActionListener(this);

        Unpack = new JButton("Unpack Files");
        Dimension b2size = Pack.getPreferredSize();
        Unpack.setBounds(300,100,b2size.width + 60, b2size.height);
        Unpack.addActionListener(this);

        _header.add(label);
        _content.add(Pack);
        _content.add(Unpack);

        ClockHome();
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            this.setVisible(false);
            System.exit(0);
        }
        if(ae.getSource() == minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource() == Pack)
        {
            this.setVisible(false);
            try
            {
                MarvellousPackFront obj = new MarvellousPackFront();
            }
            catch(Exception e){}
        }
        if(ae.getSource() == Unpack)
        {
            this.setVisible(false);
            MarvellousUnpackFront obj = new MarvellousUnpackFront();
        }
    }
}