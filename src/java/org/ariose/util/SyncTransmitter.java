package org.ariose.util;

import ie.omk.smpp.Address;
import ie.omk.smpp.Connection;
import ie.omk.smpp.message.BindResp;
import ie.omk.smpp.message.SMPPPacket;
import ie.omk.smpp.message.SubmitSM;
import ie.omk.smpp.message.SubmitSMResp;
import ie.omk.smpp.message.UnbindResp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Example class to submit a message to a SMSC using synchronous communication.
 * This class simply binds to the server, submits a message, and then unbinds.
 * 
 */
public class SyncTransmitter  {

    private Log logger = LogFactory.getLog(SyncTransmitter.class);

    public SyncTransmitter() {
    }

    String hostName = "10.82.250.50";
    int port = 5120;
    String systemID = "LBS";
    String password = "123";
    String systemType;
    int sourceTON;
    int sourceNPI;
    String sourceAddress;

    public void execute(String data) throws Exception {
        try {
            logger.info("Binding to the SMSC");

            Connection myConnection = new Connection(hostName, port);
            myConnection.autoAckLink(true);
            myConnection.autoAckMessages(true);

            BindResp resp = myConnection.bind(
                    Connection.TRANSMITTER,
                    systemID,
                    password,
                    systemType,
                    sourceTON,
                    sourceNPI,
                    sourceAddress);

            if (resp.getCommandStatus() != 0) {
                logger.info("SMSC bind failed.");
                System.exit(1);
            }

            logger.info("Bind successful...submitting a message.");

            // Submit a simple message
            SubmitSM sm = (SubmitSM) myConnection.newInstance(SMPPPacket.SUBMIT_SM);
            sm.setDestination(new Address(0, 0, "3188332314"));
            sm.setMessageText(data);
            SubmitSMResp smr = (SubmitSMResp) myConnection.sendRequest(sm);

            logger.info("Submitted message ID: " + smr.getMessageId());

            // Unbind.
            UnbindResp ubr = myConnection.unbind();

            if (ubr.getCommandStatus() == 0) {
                logger.info("Successfully unbound from the SMSC");
            } else {
                logger.info("There was an error unbinding.");
            }
        } catch (Exception x) {
            logger.error("could not send SMS with data:"+data,
            		x.fillInStackTrace());
            throw x;
        }
    }
    public void execute(String msisdn, String data) throws Exception {
        try {
            logger.info("Binding to the SMSC");

            Connection myConnection = new Connection(hostName, port);
            myConnection.autoAckLink(true);
            myConnection.autoAckMessages(true);

            BindResp resp = myConnection.bind(
                    Connection.TRANSMITTER,
                    systemID,
                    password,
                    systemType,
                    sourceTON,
                    sourceNPI,
                    sourceAddress);

            if (resp.getCommandStatus() != 0) {
                logger.info("SMSC bind failed.");
                System.exit(1);
            }

            logger.info("Bind successful...submitting a message.");

            // Submit a simple message
            SubmitSM sm = (SubmitSM) myConnection.newInstance(SMPPPacket.SUBMIT_SM);
            sm.setDestination(new Address(0, 0, msisdn));
            sm.setMessageText(data);
            SubmitSMResp smr = (SubmitSMResp) myConnection.sendRequest(sm);

            logger.info("Submitted message ID: " + smr.getMessageId());

            // Unbind.
            UnbindResp ubr = myConnection.unbind();

            if (ubr.getCommandStatus() == 0) {
                logger.info("Successfully unbound from the SMSC");
            } else {
                logger.info("There was an error unbinding.");
            }
        } catch (Exception x) {
            logger.error("could not send SMS with data:"+data,
            		x.fillInStackTrace());
            throw x;
        }
    }
}

