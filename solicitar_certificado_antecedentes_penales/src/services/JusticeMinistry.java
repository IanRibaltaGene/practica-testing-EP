package services;

import data.Goal;
import exception.DigitalSignatureException;

import java.rmi.ConnectException;

/**
 * External services involved in procedures from population
 */
public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}
