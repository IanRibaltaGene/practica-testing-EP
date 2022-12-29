package services;

import data.Goal;
import exception.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CriminalRecordCertf;

import java.rmi.ConnectException;

/**
 * External services involved in procedures from population
 */
public interface JusticeMinistry { // External service for the Justice Ministry
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}
