/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;
import java.util.logging.Level;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.GlobalScreen;
import java.util.logging.Logger;
import org.jnativehook.SwingDispatchService;
/**
 *
 * @author vileelf
 */
public class AutoClickerUi extends javax.swing.JFrame implements NativeKeyListener, NativeMouseListener{

    /**
     * Creates new form AutoClickerUi
     */
    private AutoClicker clicker;
    private Options options;
    public int hotkey;
    public int toggleoffhotkey;
    public int mousemask;
    private boolean started;
    public boolean mouse;
    public boolean on;
    public enum clickmethod{
        toggle,
        hold,
    };
    public clickmethod cm;
    
    public AutoClickerUi() {
        initComponents();
        clicker = new AutoClicker();
        mousemask=NativeMouseEvent.BUTTON3_MASK;
        hotkey=NativeMouseEvent.BUTTON3;
        mouse=true;
        started=false;
        on=true;
        cm=clickmethod.hold;
        options = new Options(this);
        GlobalScreen.setEventDispatcher(new SwingDispatchService());
        try{
            GlobalScreen.registerNativeHook();
        }
        catch(Exception e){
        }
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.addNativeMouseListener(this);
        msbtwclicksslider.requestFocus();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msbtwclicksslider = new javax.swing.JSlider();
        msbtwclickstextfield = new javax.swing.JTextField();
        clickspersecondtextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bttOptions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msbtwclicksslider.setMaximum(10000);
        msbtwclicksslider.setMinimum(1);
        msbtwclicksslider.setValue(1);
        msbtwclicksslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                msbtwclickssliderStateChanged(evt);
            }
        });

        msbtwclickstextfield.setText("1");
        msbtwclickstextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                msbtwclickstextfieldFocusLost(evt);
            }
        });

        clickspersecondtextfield.setText("1000");
        clickspersecondtextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clickspersecondtextfieldFocusLost(evt);
            }
        });

        jLabel1.setText("ms between clicks");

        jLabel2.setText("clicks per second");

        bttOptions.setText("Options");
        bttOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msbtwclicksslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(msbtwclickstextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clickspersecondtextfield))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttOptions)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttOptions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msbtwclickstextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clickspersecondtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(msbtwclicksslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msbtwclickssliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_msbtwclickssliderStateChanged
        // TODO add your handling code here:
        int msbtwclicks=msbtwclicksslider.getValue();
        msbtwclickstextfield.setText(Integer.toString(msbtwclicks));
        int clickspersecond=(int)(double)((1/(double)msbtwclicks)*1000);
        clickspersecondtextfield.setText(Integer.toString(clickspersecond));
        clicker.setMs(msbtwclicks);
    }//GEN-LAST:event_msbtwclickssliderStateChanged
    @Override
    public void nativeKeyTyped(NativeKeyEvent k){
        //dont care
    }
    @Override
    public void nativeMouseClicked(NativeMouseEvent k){
        //dont care
    }
    @Override
    public void nativeMousePressed(NativeMouseEvent k){
        if(on&&mouse){
            if(k.getButton()==hotkey||(k.getModifiers()&mousemask)==mousemask){
                if(!started){
                    System.out.println(k.getModifiers()&mousemask);
                    started=true;
                    int ms=Integer.parseInt(msbtwclickstextfield.getText());
                    clicker = new AutoClicker(ms);
                    clicker.startclick();
                    clicker.start();
                }
            }
        }
    }
    @Override
    public void nativeMouseReleased(NativeMouseEvent k){
        
        if(mouse){
            if(k.getButton()==hotkey){
                if(started){
                    System.out.println(k.paramString());
                    started=false;
                    clicker.stopclick();
                    try{
                        clicker.stop();
                    }
                    catch (Exception e){

                    }
                }
            }
        }
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent k){
        if(on&&k.getKeyCode()==hotkey){
            if(!started){
                System.out.println(k.getKeyChar());
                started=true;
                int ms=Integer.parseInt(msbtwclickstextfield.getText());
                clicker = new AutoClicker(ms);
                clicker.startclick();
                clicker.start();
            }
        }
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent k){
        if(k.getKeyCode()==hotkey){
            if(started){
                System.out.println(k.getKeyChar());
                started=false;
                clicker.stopclick();
                try{
                    clicker.stop();
                }
                catch (Exception e){

                }
            }
        }
    }
    private void msbtwclickstextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_msbtwclickstextfieldFocusLost
        // TODO add your handling code here:
        int msbtwclicks=Integer.parseInt(msbtwclickstextfield.getText());
        if(msbtwclicks<1){
            msbtwclickstextfield.setText("1");
            clickspersecondtextfield.setText("1000");
            msbtwclicksslider.setValue(1);
            clicker.setMs(1);
        }
        else {
            int clickspersecond=(int)(double)((1/(double)msbtwclicks)*1000);
            clickspersecondtextfield.setText(Integer.toString(clickspersecond));
            msbtwclicksslider.setValue(msbtwclicks<10000?msbtwclicks:10000);
            clicker.setMs(msbtwclicks);
        }
    }//GEN-LAST:event_msbtwclickstextfieldFocusLost

    private void clickspersecondtextfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clickspersecondtextfieldFocusLost

        int clickspersecond=Integer.parseInt(clickspersecondtextfield.getText());
        if(clickspersecond>1000){
            clickspersecondtextfield.setText("1000");
            msbtwclicksslider.setValue(1);
            msbtwclickstextfield.setText("1");
            clicker.setMs(1);
        }
        else {
            if(clickspersecond>0){
                int msbtwclicks=(int)(double)((1/(double)clickspersecond)*1000);
                msbtwclicksslider.setValue(msbtwclicks);
                msbtwclickstextfield.setText(Integer.toString(msbtwclicks));
                clicker.setMs(msbtwclicks);
            }
            else {
                clickspersecondtextfield.setText("0");
            }
        }
    }//GEN-LAST:event_clickspersecondtextfieldFocusLost

    private void bttOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttOptionsActionPerformed
        // goto options page
        
    }//GEN-LAST:event_bttOptionsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutoClickerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoClickerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoClickerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoClickerUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoClickerUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttOptions;
    private javax.swing.JTextField clickspersecondtextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider msbtwclicksslider;
    private javax.swing.JTextField msbtwclickstextfield;
    // End of variables declaration//GEN-END:variables
}
