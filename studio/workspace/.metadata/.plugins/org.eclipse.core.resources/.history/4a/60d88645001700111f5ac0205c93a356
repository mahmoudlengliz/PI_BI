// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package local_project.dimevenements_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: dimevenements Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class dimevenements implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "dimevenements";
	private final String projectName = "LOCAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					dimevenements.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(dimevenements.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];

		public String a_evenement;

		public String getA_evenement() {
			return this.a_evenement;
		}

		public String type_evenement;

		public String getType_evenement() {
			return this.type_evenement;
		}

		public String nom_evenement;

		public String getNom_evenement() {
			return this.nom_evenement;
		}

		public String impact_trafic;

		public String getImpact_trafic() {
			return this.impact_trafic;
		}

		public String type_vacances;

		public String getType_vacances() {
			return this.type_vacances;
		}

		public String en_vacances;

		public String getEn_vacances() {
			return this.en_vacances;
		}

		public String zone_scolaire;

		public String getZone_scolaire() {
			return this.zone_scolaire;
		}

		public String jours_feries_noms;

		public String getJours_feries_noms() {
			return this.jours_feries_noms;
		}

		public int fkzone_id;

		public int getFkzone_id() {
			return this.fkzone_id;
		}

		public int fkmois_id;

		public int getFkmois_id() {
			return this.fkmois_id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.type_vacances = readString(dis);

					this.en_vacances = readString(dis);

					this.zone_scolaire = readString(dis);

					this.jours_feries_noms = readString(dis);

					this.fkzone_id = dis.readInt();

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.type_vacances = readString(dis);

					this.en_vacances = readString(dis);

					this.zone_scolaire = readString(dis);

					this.jours_feries_noms = readString(dis);

					this.fkzone_id = dis.readInt();

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.type_vacances, dos);

				// String

				writeString(this.en_vacances, dos);

				// String

				writeString(this.zone_scolaire, dos);

				// String

				writeString(this.jours_feries_noms, dos);

				// int

				dos.writeInt(this.fkzone_id);

				// int

				dos.writeInt(this.fkmois_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.type_vacances, dos);

				// String

				writeString(this.en_vacances, dos);

				// String

				writeString(this.zone_scolaire, dos);

				// String

				writeString(this.jours_feries_noms, dos);

				// int

				dos.writeInt(this.fkzone_id);

				// int

				dos.writeInt(this.fkmois_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("a_evenement=" + a_evenement);
			sb.append(",type_evenement=" + type_evenement);
			sb.append(",nom_evenement=" + nom_evenement);
			sb.append(",impact_trafic=" + impact_trafic);
			sb.append(",type_vacances=" + type_vacances);
			sb.append(",en_vacances=" + en_vacances);
			sb.append(",zone_scolaire=" + zone_scolaire);
			sb.append(",jours_feries_noms=" + jours_feries_noms);
			sb.append(",fkzone_id=" + String.valueOf(fkzone_id));
			sb.append(",fkmois_id=" + String.valueOf(fkmois_id));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String a_evenement;

		public String getA_evenement() {
			return this.a_evenement;
		}

		public String type_evenement;

		public String getType_evenement() {
			return this.type_evenement;
		}

		public String nom_evenement;

		public String getNom_evenement() {
			return this.nom_evenement;
		}

		public String impact_trafic;

		public String getImpact_trafic() {
			return this.impact_trafic;
		}

		public String zone_scolaire;

		public String getZone_scolaire() {
			return this.zone_scolaire;
		}

		public String en_vacances;

		public String getEn_vacances() {
			return this.en_vacances;
		}

		public String type_vacances;

		public String getType_vacances() {
			return this.type_vacances;
		}

		public String jours_feries_noms;

		public String getJours_feries_noms() {
			return this.jours_feries_noms;
		}

		public int fkmois_id;

		public int getFkmois_id() {
			return this.fkmois_id;
		}

		public Integer fkzone_id;

		public Integer getFkzone_id() {
			return this.fkzone_id;
		}

		public Integer skevent;

		public Integer getSkevent() {
			return this.skevent;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.skevent == null) ? 0 : this.skevent.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out2Struct other = (out2Struct) obj;

			if (this.skevent == null) {
				if (other.skevent != null)
					return false;

			} else if (!this.skevent.equals(other.skevent))

				return false;

			return true;
		}

		public void copyDataTo(out2Struct other) {

			other.a_evenement = this.a_evenement;
			other.type_evenement = this.type_evenement;
			other.nom_evenement = this.nom_evenement;
			other.impact_trafic = this.impact_trafic;
			other.zone_scolaire = this.zone_scolaire;
			other.en_vacances = this.en_vacances;
			other.type_vacances = this.type_vacances;
			other.jours_feries_noms = this.jours_feries_noms;
			other.fkmois_id = this.fkmois_id;
			other.fkzone_id = this.fkzone_id;
			other.skevent = this.skevent;

		}

		public void copyKeysDataTo(out2Struct other) {

			other.skevent = this.skevent;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.zone_scolaire = readString(dis);

					this.en_vacances = readString(dis);

					this.type_vacances = readString(dis);

					this.jours_feries_noms = readString(dis);

					this.fkmois_id = dis.readInt();

					this.fkzone_id = readInteger(dis);

					this.skevent = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.zone_scolaire = readString(dis);

					this.en_vacances = readString(dis);

					this.type_vacances = readString(dis);

					this.jours_feries_noms = readString(dis);

					this.fkmois_id = dis.readInt();

					this.fkzone_id = readInteger(dis);

					this.skevent = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.zone_scolaire, dos);

				// String

				writeString(this.en_vacances, dos);

				// String

				writeString(this.type_vacances, dos);

				// String

				writeString(this.jours_feries_noms, dos);

				// int

				dos.writeInt(this.fkmois_id);

				// Integer

				writeInteger(this.fkzone_id, dos);

				// Integer

				writeInteger(this.skevent, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.zone_scolaire, dos);

				// String

				writeString(this.en_vacances, dos);

				// String

				writeString(this.type_vacances, dos);

				// String

				writeString(this.jours_feries_noms, dos);

				// int

				dos.writeInt(this.fkmois_id);

				// Integer

				writeInteger(this.fkzone_id, dos);

				// Integer

				writeInteger(this.skevent, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("a_evenement=" + a_evenement);
			sb.append(",type_evenement=" + type_evenement);
			sb.append(",nom_evenement=" + nom_evenement);
			sb.append(",impact_trafic=" + impact_trafic);
			sb.append(",zone_scolaire=" + zone_scolaire);
			sb.append(",en_vacances=" + en_vacances);
			sb.append(",type_vacances=" + type_vacances);
			sb.append(",jours_feries_noms=" + jours_feries_noms);
			sb.append(",fkmois_id=" + String.valueOf(fkmois_id));
			sb.append(",fkzone_id=" + String.valueOf(fkzone_id));
			sb.append(",skevent=" + String.valueOf(skevent));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.skevent, other.skevent);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String zone;

		public String getZone() {
			return this.zone;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		public String mois;

		public String getMois() {
			return this.mois;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String a_evenement;

		public String getA_evenement() {
			return this.a_evenement;
		}

		public String type_evenement;

		public String getType_evenement() {
			return this.type_evenement;
		}

		public String nom_evenement;

		public String getNom_evenement() {
			return this.nom_evenement;
		}

		public String impact_trafic;

		public String getImpact_trafic() {
			return this.impact_trafic;
		}

		public String source_info;

		public String getSource_info() {
			return this.source_info;
		}

		public String source_site;

		public String getSource_site() {
			return this.source_site;
		}

		public String date_collecte;

		public String getDate_collecte() {
			return this.date_collecte;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

					this.date = readString(dis);

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.source_info = readString(dis);

					this.source_site = readString(dis);

					this.date_collecte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

					this.date = readString(dis);

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.source_info = readString(dis);

					this.source_site = readString(dis);

					this.date_collecte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.source_info, dos);

				// String

				writeString(this.source_site, dos);

				// String

				writeString(this.date_collecte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.source_info, dos);

				// String

				writeString(this.source_site, dos);

				// String

				writeString(this.date_collecte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone=" + zone);
			sb.append(",annee=" + annee);
			sb.append(",mois=" + mois);
			sb.append(",date=" + date);
			sb.append(",a_evenement=" + a_evenement);
			sb.append(",type_evenement=" + type_evenement);
			sb.append(",nom_evenement=" + nom_evenement);
			sb.append(",impact_trafic=" + impact_trafic);
			sb.append(",source_info=" + source_info);
			sb.append(",source_site=" + source_site);
			sb.append(",date_collecte=" + date_collecte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_3Struct implements routines.system.IPersistableRow<after_tDBInput_3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String zone;

		public String getZone() {
			return this.zone;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		public String mois;

		public String getMois() {
			return this.mois;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String a_evenement;

		public String getA_evenement() {
			return this.a_evenement;
		}

		public String type_evenement;

		public String getType_evenement() {
			return this.type_evenement;
		}

		public String nom_evenement;

		public String getNom_evenement() {
			return this.nom_evenement;
		}

		public String impact_trafic;

		public String getImpact_trafic() {
			return this.impact_trafic;
		}

		public String source_info;

		public String getSource_info() {
			return this.source_info;
		}

		public String source_site;

		public String getSource_site() {
			return this.source_site;
		}

		public String date_collecte;

		public String getDate_collecte() {
			return this.date_collecte;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

					this.date = readString(dis);

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.source_info = readString(dis);

					this.source_site = readString(dis);

					this.date_collecte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

					this.date = readString(dis);

					this.a_evenement = readString(dis);

					this.type_evenement = readString(dis);

					this.nom_evenement = readString(dis);

					this.impact_trafic = readString(dis);

					this.source_info = readString(dis);

					this.source_site = readString(dis);

					this.date_collecte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.source_info, dos);

				// String

				writeString(this.source_site, dos);

				// String

				writeString(this.date_collecte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.a_evenement, dos);

				// String

				writeString(this.type_evenement, dos);

				// String

				writeString(this.nom_evenement, dos);

				// String

				writeString(this.impact_trafic, dos);

				// String

				writeString(this.source_info, dos);

				// String

				writeString(this.source_site, dos);

				// String

				writeString(this.date_collecte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone=" + zone);
			sb.append(",annee=" + annee);
			sb.append(",mois=" + mois);
			sb.append(",date=" + date);
			sb.append(",a_evenement=" + a_evenement);
			sb.append(",type_evenement=" + type_evenement);
			sb.append(",nom_evenement=" + nom_evenement);
			sb.append(",impact_trafic=" + impact_trafic);
			sb.append(",source_info=" + source_info);
			sb.append(",source_site=" + source_site);
			sb.append(",date_collecte=" + date_collecte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_1Process(globalMap);
				tDBInput_2Process(globalMap);
				tDBInput_4Process(globalMap);
				tDBInput_5Process(globalMap);
				tDBInput_6Process(globalMap);

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				out2Struct out2 = new out2Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
				}

				int tos_count_tDBOutput_1 = 0;

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;
				String dbschema_tDBOutput_1 = null;
				String tableName_tDBOutput_1 = null;
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_1;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "";
				String driverClass_tDBOutput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String port_tDBOutput_1 = "1433";
				String dbname_tDBOutput_1 = "dwurbanmobility";
				String url_tDBOutput_1 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_1)) {
					url_tDBOutput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_1)) {
					url_tDBOutput_1 += ";databaseName=" + "dwurbanmobility";

				}
				url_tDBOutput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_1 = "miming";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:u/4ew/y1QE8fzTE5Siug+pwyP896gY7RlF0jhhaytorsKA==");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = "dimevents";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "dimevents";
				}
				int count_tDBOutput_1 = 0;

				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([a_evenement],[type_evenement],[nom_evenement],[impact_trafic],[type_vacances],[en_vacances],[zone_scolaire],[jours_feries_noms],[fkzone_id],[fkmois_id]) VALUES (?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out2");
				}

				int tos_count_tDBOutput_2 = 0;

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;
				String dbschema_tDBOutput_2 = null;
				String tableName_tDBOutput_2 = null;
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				long year1_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_2;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_2 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				int updateKeyCount_tDBOutput_2 = 1;
				if (updateKeyCount_tDBOutput_2 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_2 == 11 && true) {
					throw new RuntimeException("For update, every Schema column can not be a key");
				}

				java.sql.Connection conn_tDBOutput_2 = null;
				String dbUser_tDBOutput_2 = null;
				dbschema_tDBOutput_2 = "";
				String driverClass_tDBOutput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_2);
				String port_tDBOutput_2 = "1433";
				String dbname_tDBOutput_2 = "dwurbanmobility";
				String url_tDBOutput_2 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_2)) {
					url_tDBOutput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_2)) {
					url_tDBOutput_2 += ";databaseName=" + "dwurbanmobility";

				}
				url_tDBOutput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_2 = "miming";

				final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:b4D8h/lA9SDkL1+Klwsj1fpULtmBRoLsujawsrNT/J891w==");

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);

				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				int batchSize_tDBOutput_2 = 10000;
				int batchSizeCounter_tDBOutput_2 = 0;

				if (dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
					tableName_tDBOutput_2 = "dimevents";
				} else {
					tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].[" + "dimevents";
				}
				int count_tDBOutput_2 = 0;

				String update_tDBOutput_2 = "UPDATE [" + tableName_tDBOutput_2
						+ "] SET [a_evenement] = ?,[type_evenement] = ?,[nom_evenement] = ?,[impact_trafic] = ?,[zone_scolaire] = ?,[en_vacances] = ?,[type_vacances] = ?,[jours_feries_noms] = ?,[fkmois_id] = ?,[fkzone_id] = ? WHERE [skevent] = ?";
				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) globalMap
						.get("tHash_Lookup_row5"));

				row5Struct row5HashKey = new row5Struct();
				row5Struct row5Default = new row5Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) globalMap
						.get("tHash_Lookup_row6"));

				row6Struct row6HashKey = new row6Struct();
				row6Struct row6Default = new row6Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out1Struct out1_tmp = new out1Struct();
				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_3 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3);
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "miming";

				final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:Q5r4Ecg8AlCf70B85A0F+8mfcfR11Jjw59NZiLzBirPsLg==");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String port_tDBInput_3 = "1433";
				String dbname_tDBInput_3 = "UrbanMobility";
				String url_tDBInput_3 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_3)) {
					url_tDBInput_3 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_3)) {
					url_tDBInput_3 += ";databaseName=" + "UrbanMobility";
				}
				url_tDBInput_3 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_3 = "dbo";

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT dbo.staginggreves.zone_id,\n		dbo.staginggreves.zone,\n		dbo.staginggreves.annee,\n		dbo.staginggreves.mois,\n		dbo."
						+ "staginggreves.date,\n		dbo.staginggreves.a_evenement,\n		dbo.staginggreves.type_evenement,\n		dbo.staginggreves.nom_eveneme"
						+ "nt,\n		dbo.staginggreves.impact_trafic,\n		dbo.staginggreves.source_info,\n		dbo.staginggreves.source_site,\n		dbo.staginggr"
						+ "eves.date_collecte\nFROM	dbo.staginggreves";

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row1.zone_id = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(1);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.zone_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.zone_id = tmpContent_tDBInput_3;
								}
							} else {
								row1.zone_id = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row1.zone = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.zone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.zone = tmpContent_tDBInput_3;
								}
							} else {
								row1.zone = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row1.annee = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.annee = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.annee = tmpContent_tDBInput_3;
								}
							} else {
								row1.annee = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row1.mois = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.mois = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.mois = tmpContent_tDBInput_3;
								}
							} else {
								row1.mois = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row1.date = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.date = tmpContent_tDBInput_3;
								}
							} else {
								row1.date = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row1.a_evenement = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.a_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.a_evenement = tmpContent_tDBInput_3;
								}
							} else {
								row1.a_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row1.type_evenement = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.type_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.type_evenement = tmpContent_tDBInput_3;
								}
							} else {
								row1.type_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							row1.nom_evenement = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(8);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.nom_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.nom_evenement = tmpContent_tDBInput_3;
								}
							} else {
								row1.nom_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							row1.impact_trafic = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(9);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.impact_trafic = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.impact_trafic = tmpContent_tDBInput_3;
								}
							} else {
								row1.impact_trafic = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							row1.source_info = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(10);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.source_info = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.source_info = tmpContent_tDBInput_3;
								}
							} else {
								row1.source_info = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 11) {
							row1.source_site = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(11);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.source_site = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.source_site = tmpContent_tDBInput_3;
								}
							} else {
								row1.source_site = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 12) {
							row1.date_collecte = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(12);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.date_collecte = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row1.date_collecte = tmpContent_tDBInput_3;
								}
							} else {
								row1.date_collecte = null;
							}
						}

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row2"
						///////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2HashKey.zone_id = row1.zone_id;

							row2HashKey.annee = row1.annee;

							row2HashKey.mois = row1.mois;

							row2HashKey.hashCodeDirty = true;

							tHash_Lookup_row2.lookup(row2HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
							// and it contains more one result from keys : row2.zone_id = '" +
							// row2HashKey.zone_id + "', row2.annee = '" + row2HashKey.annee + "', row2.mois
							// = '" + row2HashKey.mois + "'");
						} // G 071

						row2Struct row2 = null;

						row2Struct fromLookup_row2 = null;
						row2 = row2Default;

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

							fromLookup_row2 = tHash_Lookup_row2.next();

						} // G 099

						if (fromLookup_row2 != null) {
							row2 = fromLookup_row2;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row3"
						///////////////////////////////////////////////

						boolean forceLooprow3 = false;

						row3Struct row3ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row3HashKey.zone_id = row1.zone_id;

							row3HashKey.annee = row1.annee;

							row3HashKey.mois = row1.mois;

							row3HashKey.hashCodeDirty = true;

							tHash_Lookup_row3.lookup(row3HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
							// and it contains more one result from keys : row3.zone_id = '" +
							// row3HashKey.zone_id + "', row3.annee = '" + row3HashKey.annee + "', row3.mois
							// = '" + row3HashKey.mois + "'");
						} // G 071

						row3Struct row3 = null;

						row3Struct fromLookup_row3 = null;
						row3 = row3Default;

						if (tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) { // G 099

							fromLookup_row3 = tHash_Lookup_row3.next();

						} // G 099

						if (fromLookup_row3 != null) {
							row3 = fromLookup_row3;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row4"
						///////////////////////////////////////////////

						boolean forceLooprow4 = false;

						row4Struct row4ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							Object exprKeyValue_row4__annee = Integer.parseInt(row1.annee);
							if (exprKeyValue_row4__annee == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row4HashKey.annee = (int) (Integer) exprKeyValue_row4__annee;
							}

							Object exprKeyValue_row4__mois = Integer.parseInt(row1.mois);
							if (exprKeyValue_row4__mois == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row4HashKey.mois = (int) (Integer) exprKeyValue_row4__mois;
							}

							row4HashKey.hashCodeDirty = true;

							if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

								tHash_Lookup_row4.lookup(row4HashKey);

							} // G_TM_M_091

						} // G_TM_M_020

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
							// and it contains more one result from keys : row4.annee = '" +
							// row4HashKey.annee + "', row4.mois = '" + row4HashKey.mois + "'");
						} // G 071

						row4Struct row4 = null;

						row4Struct fromLookup_row4 = null;
						row4 = row4Default;

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

							fromLookup_row4 = tHash_Lookup_row4.next();

						} // G 099

						if (fromLookup_row4 != null) {
							row4 = fromLookup_row4;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row5"
						///////////////////////////////////////////////

						boolean forceLooprow5 = false;

						row5Struct row5ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							Object exprKeyValue_row5__zone_id = Integer.parseInt(row1.zone_id);
							if (exprKeyValue_row5__zone_id == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row5HashKey.zone_id = (int) (Integer) exprKeyValue_row5__zone_id;
							}

							row5HashKey.hashCodeDirty = true;

							if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

								tHash_Lookup_row5.lookup(row5HashKey);

							} // G_TM_M_091

						} // G_TM_M_020

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
							// and it contains more one result from keys : row5.zone_id = '" +
							// row5HashKey.zone_id + "'");
						} // G 071

						row5Struct row5 = null;

						row5Struct fromLookup_row5 = null;
						row5 = row5Default;

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

							fromLookup_row5 = tHash_Lookup_row5.next();

						} // G 099

						if (fromLookup_row5 != null) {
							row5 = fromLookup_row5;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row6"
						///////////////////////////////////////////////

						boolean forceLooprow6 = false;

						row6Struct row6ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							Object exprKeyValue_row6__fkzone_id = row5.zone_id;
							if (exprKeyValue_row6__fkzone_id == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row6HashKey.fkzone_id = (int) (Integer) exprKeyValue_row6__fkzone_id;
							}

							Object exprKeyValue_row6__fkmois_id = row4.mois_id;
							if (exprKeyValue_row6__fkmois_id == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row6HashKey.fkmois_id = (int) (Integer) exprKeyValue_row6__fkmois_id;
							}

							row6HashKey.hashCodeDirty = true;

							if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

								tHash_Lookup_row6.lookup(row6HashKey);

							} // G_TM_M_091

						} // G_TM_M_020

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
							// and it contains more one result from keys : row6.fkzone_id = '" +
							// row6HashKey.fkzone_id + "', row6.fkmois_id = '" + row6HashKey.fkmois_id +
							// "'");
						} // G 071

						row6Struct row6 = null;

						row6Struct fromLookup_row6 = null;
						row6 = row6Default;

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.hasNext()) { // G 099

							fromLookup_row6 = tHash_Lookup_row6.next();

						} // G 099

						if (fromLookup_row6 != null) {
							row6 = fromLookup_row6;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;
							out2 = null;

// # Output table : 'out1'
// # Filter conditions 
							if (

							row6.skevent == null

							) {
								out1_tmp.a_evenement = row1.a_evenement;
								out1_tmp.type_evenement = (row1.type_evenement == null || row1.type_evenement.isEmpty())
										? "AUCUN"
										: row1.type_evenement;
								out1_tmp.nom_evenement = (row1.nom_evenement == null || row1.nom_evenement.isEmpty())
										? "Aucun"
										: row1.nom_evenement;
								out1_tmp.impact_trafic = row1.impact_trafic;
								out1_tmp.type_vacances = (row2.type_vacances == null || row2.type_vacances.isEmpty())
										? "EN_COURS"
										: row2.type_vacances;
								out1_tmp.en_vacances = row2.en_vacances;
								out1_tmp.zone_scolaire = row2.zone_scolaire;
								out1_tmp.jours_feries_noms = (row3.jours_feries_noms == null
										|| row3.jours_feries_noms.isEmpty()) ? "Aucun" : row3.jours_feries_noms;
								out1_tmp.fkzone_id = row5.zone_id;
								out1_tmp.fkmois_id = row4.mois_id;
								out1 = out1_tmp;
							} // closing filter/reject

// # Output table : 'out2'
// # Filter conditions 
							if (

							row6.skevent != null

							) {
								out2_tmp.a_evenement = row1.a_evenement;
								out2_tmp.type_evenement = (row1.type_evenement == null || row1.type_evenement.isEmpty())
										? "AUCUN"
										: row1.type_evenement;
								out2_tmp.nom_evenement = (row1.nom_evenement == null || row1.nom_evenement.isEmpty())
										? "Aucun"
										: row1.nom_evenement;
								out2_tmp.impact_trafic = row1.impact_trafic;
								out2_tmp.zone_scolaire = row2.zone_scolaire;
								out2_tmp.en_vacances = row2.en_vacances;
								out2_tmp.type_vacances = (row2.type_vacances == null || row2.type_vacances.isEmpty())
										? "EN_COURS"
										: row2.type_vacances;
								out2_tmp.jours_feries_noms = (row3.jours_feries_noms == null
										|| row3.jours_feries_noms.isEmpty()) ? "Aucun" : row3.jours_feries_noms;
								out2_tmp.fkmois_id = row4.mois_id;
								out2_tmp.fkzone_id = row5.zone_id;
								out2_tmp.skevent = row6.skevent;
								out2 = out2_tmp;
							} // closing filter/reject
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out1"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (out1.a_evenement == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(1, out1.a_evenement);
							}

							if (out1.type_evenement == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, out1.type_evenement);
							}

							if (out1.nom_evenement == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, out1.nom_evenement);
							}

							if (out1.impact_trafic == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, out1.impact_trafic);
							}

							if (out1.type_vacances == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(5, out1.type_vacances);
							}

							if (out1.en_vacances == null) {
								pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(6, out1.en_vacances);
							}

							if (out1.zone_scolaire == null) {
								pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(7, out1.zone_scolaire);
							}

							if (out1.jours_feries_noms == null) {
								pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(8, out1.jours_feries_noms);
							}

							pstmt_tDBOutput_1.setInt(9, out1.fkzone_id);

							pstmt_tDBOutput_1.setInt(10, out1.fkmois_id);

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							batchSizeCounter_tDBOutput_1++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_1 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_1 > 0)
									&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

								insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
										.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);
								rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;

								batchSizeCounter_tDBOutput_1 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_1++;
							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
								if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

									insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
											.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

									batchSizeCounter_tDBOutput_1 = 0;
								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {

								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "out1"

// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tDBOutput_2 main ] start
							 */

							currentComponent = "tDBOutput_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out2"

								);
							}

							whetherReject_tDBOutput_2 = false;
							if (out2.a_evenement == null) {
								pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(1, out2.a_evenement);
							}

							if (out2.type_evenement == null) {
								pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(2, out2.type_evenement);
							}

							if (out2.nom_evenement == null) {
								pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(3, out2.nom_evenement);
							}

							if (out2.impact_trafic == null) {
								pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(4, out2.impact_trafic);
							}

							if (out2.zone_scolaire == null) {
								pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(5, out2.zone_scolaire);
							}

							if (out2.en_vacances == null) {
								pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(6, out2.en_vacances);
							}

							if (out2.type_vacances == null) {
								pstmt_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(7, out2.type_vacances);
							}

							if (out2.jours_feries_noms == null) {
								pstmt_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(8, out2.jours_feries_noms);
							}

							pstmt_tDBOutput_2.setInt(9, out2.fkmois_id);

							if (out2.fkzone_id == null) {
								pstmt_tDBOutput_2.setNull(10, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_2.setInt(10, out2.fkzone_id);
							}

							if (out2.skevent == null) {
								pstmt_tDBOutput_2.setNull(11 + count_tDBOutput_2, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_2.setInt(11 + count_tDBOutput_2, out2.skevent);
							}

							pstmt_tDBOutput_2.addBatch();
							nb_line_tDBOutput_2++;

							batchSizeCounter_tDBOutput_2++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_2 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_2)
										throws Exception {
									try {

										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
												break;
											}
											counter += countEach_tDBOutput_2;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_2)
										throws Exception {
									try {

										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
												break;
											}
											counter += countEach_tDBOutput_2;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_2 > 0)
									&& (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {

								updatedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
										.limitBytePart1(updatedCount_tDBOutput_2, pstmt_tDBOutput_2);
								rowsToCommitCount_tDBOutput_2 = updatedCount_tDBOutput_2;

								batchSizeCounter_tDBOutput_2 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_2++;
							if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
								if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {

									updatedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
											.limitBytePart1(updatedCount_tDBOutput_2, pstmt_tDBOutput_2);

									batchSizeCounter_tDBOutput_2 = 0;
								}
								if (rowsToCommitCount_tDBOutput_2 != 0) {

								}
								conn_tDBOutput_2.commit();
								if (rowsToCommitCount_tDBOutput_2 != 0) {

									rowsToCommitCount_tDBOutput_2 = 0;
								}
								commitCounter_tDBOutput_2 = 0;
							}

							tos_count_tDBOutput_2++;

							/**
							 * [tDBOutput_2 main ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_end ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_end ] stop
							 */

						} // End of branch "out2"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

				if (tHash_Lookup_row5 != null) {
					tHash_Lookup_row5.endGet();
				}
				globalMap.remove("tHash_Lookup_row5");

				if (tHash_Lookup_row6 != null) {
					tHash_Lookup_row6.endGet();
				}
				globalMap.remove("tHash_Lookup_row6");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							countSum_tDBOutput_1 += countEach_tDBOutput_1;
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;
				conn_tDBOutput_1.close();
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					int countSum_tDBOutput_2 = 0;
					if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {

						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
							if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
								break;
							}
							countSum_tDBOutput_2 += countEach_tDBOutput_2;
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					}

					updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");

				}
				resourceMap.put("statementClosed_tDBOutput_2", true);
				if (rowsToCommitCount_tDBOutput_2 != 0) {

				}
				conn_tDBOutput_2.commit();
				if (rowsToCommitCount_tDBOutput_2 != 0) {

					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;
				conn_tDBOutput_2.close();
				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out2");
				}

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row3");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row5");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row6");

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								ctn_tDBOutput_2.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String zone;

		public String getZone() {
			return this.zone;
		}

		public String zone_scolaire;

		public String getZone_scolaire() {
			return this.zone_scolaire;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		public String mois;

		public String getMois() {
			return this.mois;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String en_vacances;

		public String getEn_vacances() {
			return this.en_vacances;
		}

		public String type_vacances;

		public String getType_vacances() {
			return this.type_vacances;
		}

		public String source;

		public String getSource() {
			return this.source;
		}

		public String url;

		public String getUrl() {
			return this.url;
		}

		public String date_collecte;

		public String getDate_collecte() {
			return this.date_collecte;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.zone_id == null) ? 0 : this.zone_id.hashCode());

				result = prime * result + ((this.annee == null) ? 0 : this.annee.hashCode());

				result = prime * result + ((this.mois == null) ? 0 : this.mois.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.zone_id == null) {
				if (other.zone_id != null)
					return false;

			} else if (!this.zone_id.equals(other.zone_id))

				return false;

			if (this.annee == null) {
				if (other.annee != null)
					return false;

			} else if (!this.annee.equals(other.annee))

				return false;

			if (this.mois == null) {
				if (other.mois != null)
					return false;

			} else if (!this.mois.equals(other.mois))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.zone_id = this.zone_id;
			other.zone = this.zone;
			other.zone_scolaire = this.zone_scolaire;
			other.annee = this.annee;
			other.mois = this.mois;
			other.date = this.date;
			other.en_vacances = this.en_vacances;
			other.type_vacances = this.type_vacances;
			other.source = this.source;
			other.url = this.url;
			other.date_collecte = this.date_collecte;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.zone_id = this.zone_id;
			other.annee = this.annee;
			other.mois = this.mois;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.zone = readString(dis, ois);

				this.zone_scolaire = readString(dis, ois);

				this.date = readString(dis, ois);

				this.en_vacances = readString(dis, ois);

				this.type_vacances = readString(dis, ois);

				this.source = readString(dis, ois);

				this.url = readString(dis, ois);

				this.date_collecte = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.zone = readString(dis, objectIn);

				this.zone_scolaire = readString(dis, objectIn);

				this.date = readString(dis, objectIn);

				this.en_vacances = readString(dis, objectIn);

				this.type_vacances = readString(dis, objectIn);

				this.source = readString(dis, objectIn);

				this.url = readString(dis, objectIn);

				this.date_collecte = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.zone, dos, oos);

				writeString(this.zone_scolaire, dos, oos);

				writeString(this.date, dos, oos);

				writeString(this.en_vacances, dos, oos);

				writeString(this.type_vacances, dos, oos);

				writeString(this.source, dos, oos);

				writeString(this.url, dos, oos);

				writeString(this.date_collecte, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.zone, dos, objectOut);

				writeString(this.zone_scolaire, dos, objectOut);

				writeString(this.date, dos, objectOut);

				writeString(this.en_vacances, dos, objectOut);

				writeString(this.type_vacances, dos, objectOut);

				writeString(this.source, dos, objectOut);

				writeString(this.url, dos, objectOut);

				writeString(this.date_collecte, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone=" + zone);
			sb.append(",zone_scolaire=" + zone_scolaire);
			sb.append(",annee=" + annee);
			sb.append(",mois=" + mois);
			sb.append(",date=" + date);
			sb.append(",en_vacances=" + en_vacances);
			sb.append(",type_vacances=" + type_vacances);
			sb.append(",source=" + source);
			sb.append(",url=" + url);
			sb.append(",date_collecte=" + date_collecte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.zone_id, other.zone_id);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.annee, other.annee);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.mois, other.mois);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tDBInput_1 - inputs:(after_tDBInput_3) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(out1,out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "miming";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:OkWvqgX0qWeUTYMrI0gH2OYtguqoMiM1fcrjqWZ8i0XSdQ==");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "UrbanMobility";
				String url_tDBInput_1 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += ";databaseName=" + "UrbanMobility";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_1 = "dbo";

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT dbo.stagingcalendrierscolaire.zone_id,\n		dbo.stagingcalendrierscolaire.zone,\n		dbo.stagingcalendrierscolaire.zon"
						+ "e_scolaire,\n		dbo.stagingcalendrierscolaire.annee,\n		dbo.stagingcalendrierscolaire.mois,\n		dbo.stagingcalendrierscolaire"
						+ ".date,\n		dbo.stagingcalendrierscolaire.en_vacances,\n		dbo.stagingcalendrierscolaire.type_vacances,\n		dbo.stagingcalendri"
						+ "erscolaire.source,\n		dbo.stagingcalendrierscolaire.url,\n		dbo.stagingcalendrierscolaire.date_collecte\nFROM	dbo.stagingca"
						+ "lendrierscolaire";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row2.zone_id = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.zone_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.zone_id = tmpContent_tDBInput_1;
								}
							} else {
								row2.zone_id = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row2.zone = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.zone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.zone = tmpContent_tDBInput_1;
								}
							} else {
								row2.zone = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row2.zone_scolaire = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.zone_scolaire = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.zone_scolaire = tmpContent_tDBInput_1;
								}
							} else {
								row2.zone_scolaire = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row2.annee = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.annee = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.annee = tmpContent_tDBInput_1;
								}
							} else {
								row2.annee = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row2.mois = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.mois = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.mois = tmpContent_tDBInput_1;
								}
							} else {
								row2.mois = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row2.date = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.date = tmpContent_tDBInput_1;
								}
							} else {
								row2.date = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row2.en_vacances = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.en_vacances = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.en_vacances = tmpContent_tDBInput_1;
								}
							} else {
								row2.en_vacances = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row2.type_vacances = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.type_vacances = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.type_vacances = tmpContent_tDBInput_1;
								}
							} else {
								row2.type_vacances = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row2.source = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.source = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.source = tmpContent_tDBInput_1;
								}
							} else {
								row2.source = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							row2.url = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.url = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.url = tmpContent_tDBInput_1;
								}
							} else {
								row2.url = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							row2.date_collecte = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.date_collecte = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row2.date_collecte = tmpContent_tDBInput_1;
								}
							} else {
								row2.date_collecte = null;
							}
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row2"

							);
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.zone_id = row2.zone_id;

						row2_HashRow.zone = row2.zone;

						row2_HashRow.zone_scolaire = row2.zone_scolaire;

						row2_HashRow.annee = row2.annee;

						row2_HashRow.mois = row2.mois;

						row2_HashRow.date = row2.date;

						row2_HashRow.en_vacances = row2.en_vacances;

						row2_HashRow.type_vacances = row2.type_vacances;

						row2_HashRow.source = row2.source;

						row2_HashRow.url = row2.url;

						row2_HashRow.date_collecte = row2.date_collecte;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String zone;

		public String getZone() {
			return this.zone;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		public String mois;

		public String getMois() {
			return this.mois;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String nb_jours_feries;

		public String getNb_jours_feries() {
			return this.nb_jours_feries;
		}

		public String jours_feries_noms;

		public String getJours_feries_noms() {
			return this.jours_feries_noms;
		}

		public String nb_jours_totaux;

		public String getNb_jours_totaux() {
			return this.nb_jours_totaux;
		}

		public String nb_jours_weekends;

		public String getNb_jours_weekends() {
			return this.nb_jours_weekends;
		}

		public String nb_jours_ouvres;

		public String getNb_jours_ouvres() {
			return this.nb_jours_ouvres;
		}

		public String source;

		public String getSource() {
			return this.source;
		}

		public String url;

		public String getUrl() {
			return this.url;
		}

		public String date_collecte;

		public String getDate_collecte() {
			return this.date_collecte;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.zone_id == null) ? 0 : this.zone_id.hashCode());

				result = prime * result + ((this.annee == null) ? 0 : this.annee.hashCode());

				result = prime * result + ((this.mois == null) ? 0 : this.mois.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.zone_id == null) {
				if (other.zone_id != null)
					return false;

			} else if (!this.zone_id.equals(other.zone_id))

				return false;

			if (this.annee == null) {
				if (other.annee != null)
					return false;

			} else if (!this.annee.equals(other.annee))

				return false;

			if (this.mois == null) {
				if (other.mois != null)
					return false;

			} else if (!this.mois.equals(other.mois))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.zone_id = this.zone_id;
			other.zone = this.zone;
			other.annee = this.annee;
			other.mois = this.mois;
			other.date = this.date;
			other.nb_jours_feries = this.nb_jours_feries;
			other.jours_feries_noms = this.jours_feries_noms;
			other.nb_jours_totaux = this.nb_jours_totaux;
			other.nb_jours_weekends = this.nb_jours_weekends;
			other.nb_jours_ouvres = this.nb_jours_ouvres;
			other.source = this.source;
			other.url = this.url;
			other.date_collecte = this.date_collecte;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.zone_id = this.zone_id;
			other.annee = this.annee;
			other.mois = this.mois;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_dimevenements.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_dimevenements.length == 0) {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_dimevenements = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_dimevenements, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.annee = readString(dis);

					this.mois = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.annee, dos);

				// String

				writeString(this.mois, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.zone = readString(dis, ois);

				this.date = readString(dis, ois);

				this.nb_jours_feries = readString(dis, ois);

				this.jours_feries_noms = readString(dis, ois);

				this.nb_jours_totaux = readString(dis, ois);

				this.nb_jours_weekends = readString(dis, ois);

				this.nb_jours_ouvres = readString(dis, ois);

				this.source = readString(dis, ois);

				this.url = readString(dis, ois);

				this.date_collecte = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.zone = readString(dis, objectIn);

				this.date = readString(dis, objectIn);

				this.nb_jours_feries = readString(dis, objectIn);

				this.jours_feries_noms = readString(dis, objectIn);

				this.nb_jours_totaux = readString(dis, objectIn);

				this.nb_jours_weekends = readString(dis, objectIn);

				this.nb_jours_ouvres = readString(dis, objectIn);

				this.source = readString(dis, objectIn);

				this.url = readString(dis, objectIn);

				this.date_collecte = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.zone, dos, oos);

				writeString(this.date, dos, oos);

				writeString(this.nb_jours_feries, dos, oos);

				writeString(this.jours_feries_noms, dos, oos);

				writeString(this.nb_jours_totaux, dos, oos);

				writeString(this.nb_jours_weekends, dos, oos);

				writeString(this.nb_jours_ouvres, dos, oos);

				writeString(this.source, dos, oos);

				writeString(this.url, dos, oos);

				writeString(this.date_collecte, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.zone, dos, objectOut);

				writeString(this.date, dos, objectOut);

				writeString(this.nb_jours_feries, dos, objectOut);

				writeString(this.jours_feries_noms, dos, objectOut);

				writeString(this.nb_jours_totaux, dos, objectOut);

				writeString(this.nb_jours_weekends, dos, objectOut);

				writeString(this.nb_jours_ouvres, dos, objectOut);

				writeString(this.source, dos, objectOut);

				writeString(this.url, dos, objectOut);

				writeString(this.date_collecte, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone=" + zone);
			sb.append(",annee=" + annee);
			sb.append(",mois=" + mois);
			sb.append(",date=" + date);
			sb.append(",nb_jours_feries=" + nb_jours_feries);
			sb.append(",jours_feries_noms=" + jours_feries_noms);
			sb.append(",nb_jours_totaux=" + nb_jours_totaux);
			sb.append(",nb_jours_weekends=" + nb_jours_weekends);
			sb.append(",nb_jours_ouvres=" + nb_jours_ouvres);
			sb.append(",source=" + source);
			sb.append(",url=" + url);
			sb.append(",date_collecte=" + date_collecte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.zone_id, other.zone_id);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.annee, other.annee);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.mois, other.mois);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tAdvancedHash_row3 = 0;

				// connection name:row3
				// source node:tDBInput_2 - inputs:(after_tDBInput_3) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(out1,out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_2 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2);
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "miming";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:mcPVCIeBby1grKVQ1SaHralHRTUMN6omtEoGenhbnkbQ/w==");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String port_tDBInput_2 = "1433";
				String dbname_tDBInput_2 = "UrbanMobility";
				String url_tDBInput_2 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_2)) {
					url_tDBInput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_2)) {
					url_tDBInput_2 += ";databaseName=" + "UrbanMobility";
				}
				url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_2 = "dbo";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT dbo.stagingferiers.zone_id,\n		dbo.stagingferiers.zone,\n		dbo.stagingferiers.annee,\n		dbo.stagingferiers.mois,\n		"
						+ "dbo.stagingferiers.date,\n		dbo.stagingferiers.nb_jours_feries,\n		dbo.stagingferiers.jours_feries_noms,\n		dbo.stagingferi"
						+ "ers.nb_jours_totaux,\n		dbo.stagingferiers.nb_jours_weekends,\n		dbo.stagingferiers.nb_jours_ouvres,\n		dbo.stagingferiers."
						+ "source,\n		dbo.stagingferiers.url,\n		dbo.stagingferiers.date_collecte\nFROM	dbo.stagingferiers";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row3.zone_id = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.zone_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.zone_id = tmpContent_tDBInput_2;
								}
							} else {
								row3.zone_id = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row3.zone = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.zone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.zone = tmpContent_tDBInput_2;
								}
							} else {
								row3.zone = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row3.annee = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.annee = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.annee = tmpContent_tDBInput_2;
								}
							} else {
								row3.annee = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row3.mois = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.mois = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.mois = tmpContent_tDBInput_2;
								}
							} else {
								row3.mois = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row3.date = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.date = tmpContent_tDBInput_2;
								}
							} else {
								row3.date = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row3.nb_jours_feries = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.nb_jours_feries = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.nb_jours_feries = tmpContent_tDBInput_2;
								}
							} else {
								row3.nb_jours_feries = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row3.jours_feries_noms = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.jours_feries_noms = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.jours_feries_noms = tmpContent_tDBInput_2;
								}
							} else {
								row3.jours_feries_noms = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							row3.nb_jours_totaux = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.nb_jours_totaux = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.nb_jours_totaux = tmpContent_tDBInput_2;
								}
							} else {
								row3.nb_jours_totaux = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							row3.nb_jours_weekends = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(9);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.nb_jours_weekends = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.nb_jours_weekends = tmpContent_tDBInput_2;
								}
							} else {
								row3.nb_jours_weekends = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							row3.nb_jours_ouvres = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(10);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.nb_jours_ouvres = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.nb_jours_ouvres = tmpContent_tDBInput_2;
								}
							} else {
								row3.nb_jours_ouvres = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 11) {
							row3.source = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.source = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.source = tmpContent_tDBInput_2;
								}
							} else {
								row3.source = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 12) {
							row3.url = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(12);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.url = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.url = tmpContent_tDBInput_2;
								}
							} else {
								row3.url = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 13) {
							row3.date_collecte = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(13);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.date_collecte = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row3.date_collecte = tmpContent_tDBInput_2;
								}
							} else {
								row3.date_collecte = null;
							}
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.zone_id = row3.zone_id;

						row3_HashRow.zone = row3.zone;

						row3_HashRow.annee = row3.annee;

						row3_HashRow.mois = row3.mois;

						row3_HashRow.date = row3.date;

						row3_HashRow.nb_jours_feries = row3.nb_jours_feries;

						row3_HashRow.jours_feries_noms = row3.jours_feries_noms;

						row3_HashRow.nb_jours_totaux = row3.nb_jours_totaux;

						row3_HashRow.nb_jours_weekends = row3.nb_jours_weekends;

						row3_HashRow.nb_jours_ouvres = row3.nb_jours_ouvres;

						row3_HashRow.source = row3.source;

						row3_HashRow.url = row3.url;

						row3_HashRow.date_collecte = row3.date_collecte;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int time_id;

		public int getTime_id() {
			return this.time_id;
		}

		public int date_id;

		public int getDate_id() {
			return this.date_id;
		}

		public int mois_id;

		public int getMois_id() {
			return this.mois_id;
		}

		public java.util.Date BK_date;

		public java.util.Date getBK_date() {
			return this.BK_date;
		}

		public String heure;

		public String getHeure() {
			return this.heure;
		}

		public int annee;

		public int getAnnee() {
			return this.annee;
		}

		public int mois;

		public int getMois() {
			return this.mois;
		}

		public int jour;

		public int getJour() {
			return this.jour;
		}

		public int jour_semaine;

		public int getJour_semaine() {
			return this.jour_semaine;
		}

		public boolean est_weekend;

		public boolean getEst_weekend() {
			return this.est_weekend;
		}

		public String periode;

		public String getPeriode() {
			return this.periode;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.annee;

				result = prime * result + (int) this.mois;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.annee != other.annee)
				return false;

			if (this.mois != other.mois)
				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.time_id = this.time_id;
			other.date_id = this.date_id;
			other.mois_id = this.mois_id;
			other.BK_date = this.BK_date;
			other.heure = this.heure;
			other.annee = this.annee;
			other.mois = this.mois;
			other.jour = this.jour;
			other.jour_semaine = this.jour_semaine;
			other.est_weekend = this.est_weekend;
			other.periode = this.periode;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.annee = this.annee;
			other.mois = this.mois;

		}

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.annee = dis.readInt();

					this.mois = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.annee = dis.readInt();

					this.mois = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.annee);

				// int

				dos.writeInt(this.mois);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.annee);

				// int

				dos.writeInt(this.mois);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.time_id = dis.readInt();

				this.date_id = dis.readInt();

				this.mois_id = dis.readInt();

				this.BK_date = readDate(dis, ois);

				this.heure = readString(dis, ois);

				this.jour = dis.readInt();

				this.jour_semaine = dis.readInt();

				this.est_weekend = dis.readBoolean();

				this.periode = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.time_id = objectIn.readInt();

				this.date_id = objectIn.readInt();

				this.mois_id = objectIn.readInt();

				this.BK_date = readDate(dis, objectIn);

				this.heure = readString(dis, objectIn);

				this.jour = objectIn.readInt();

				this.jour_semaine = objectIn.readInt();

				this.est_weekend = objectIn.readBoolean();

				this.periode = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.time_id);

				dos.writeInt(this.date_id);

				dos.writeInt(this.mois_id);

				writeDate(this.BK_date, dos, oos);

				writeString(this.heure, dos, oos);

				dos.writeInt(this.jour);

				dos.writeInt(this.jour_semaine);

				dos.writeBoolean(this.est_weekend);

				writeString(this.periode, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.time_id);

				objectOut.writeInt(this.date_id);

				objectOut.writeInt(this.mois_id);

				writeDate(this.BK_date, dos, objectOut);

				writeString(this.heure, dos, objectOut);

				objectOut.writeInt(this.jour);

				objectOut.writeInt(this.jour_semaine);

				objectOut.writeBoolean(this.est_weekend);

				writeString(this.periode, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("time_id=" + String.valueOf(time_id));
			sb.append(",date_id=" + String.valueOf(date_id));
			sb.append(",mois_id=" + String.valueOf(mois_id));
			sb.append(",BK_date=" + String.valueOf(BK_date));
			sb.append(",heure=" + heure);
			sb.append(",annee=" + String.valueOf(annee));
			sb.append(",mois=" + String.valueOf(mois));
			sb.append(",jour=" + String.valueOf(jour));
			sb.append(",jour_semaine=" + String.valueOf(jour_semaine));
			sb.append(",est_weekend=" + String.valueOf(est_weekend));
			sb.append(",periode=" + periode);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.annee, other.annee);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.mois, other.mois);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tDBInput_4 - inputs:(after_tDBInput_3) outputs:(row4,row4) |
				// target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(out1,out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_4 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4);
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "miming";

				final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:iyy5Jke645gZ3E/q5Z24PJFpYLeTIhGfD7hKyX7qYpyzRg==");

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String port_tDBInput_4 = "1433";
				String dbname_tDBInput_4 = "dwurbanmobility";
				String url_tDBInput_4 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_4)) {
					url_tDBInput_4 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_4)) {
					url_tDBInput_4 += ";databaseName=" + "dwurbanmobility";
				}
				url_tDBInput_4 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_4 = "";

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT DIM_TEMPS.time_id,\n		DIM_TEMPS.date_id,\n		DIM_TEMPS.mois_id,\n		DIM_TEMPS.BK_date,\n		DIM_TEMPS.heure,\n		DIM_TEMPS"
						+ ".annee,\n		DIM_TEMPS.mois,\n		DIM_TEMPS.jour,\n		DIM_TEMPS.jour_semaine,\n		DIM_TEMPS.est_weekend,\n		DIM_TEMPS.periode\nFROM	"
						+ "DIM_TEMPS";

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row4.time_id = 0;
						} else {

							row4.time_id = rs_tDBInput_4.getInt(1);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row4.date_id = 0;
						} else {

							row4.date_id = rs_tDBInput_4.getInt(2);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row4.mois_id = 0;
						} else {

							row4.mois_id = rs_tDBInput_4.getInt(3);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 4) {
							row4.BK_date = null;
						} else {

							row4.BK_date = mssqlGTU_tDBInput_4.getDate(rsmd_tDBInput_4, rs_tDBInput_4, 4);

						}
						if (colQtyInRs_tDBInput_4 < 5) {
							row4.heure = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(5);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row4.heure = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row4.heure = tmpContent_tDBInput_4;
								}
							} else {
								row4.heure = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 6) {
							row4.annee = 0;
						} else {

							row4.annee = rs_tDBInput_4.getInt(6);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 7) {
							row4.mois = 0;
						} else {

							row4.mois = rs_tDBInput_4.getInt(7);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 8) {
							row4.jour = 0;
						} else {

							row4.jour = rs_tDBInput_4.getInt(8);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 9) {
							row4.jour_semaine = 0;
						} else {

							row4.jour_semaine = rs_tDBInput_4.getInt(9);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 10) {
							row4.est_weekend = false;
						} else {

							row4.est_weekend = rs_tDBInput_4.getBoolean(10);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 11) {
							row4.periode = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(11);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row4.periode = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row4.periode = tmpContent_tDBInput_4;
								}
							} else {
								row4.periode = null;
							}
						}

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 main ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						row4Struct row4_HashRow = new row4Struct();

						row4_HashRow.time_id = row4.time_id;

						row4_HashRow.date_id = row4.date_id;

						row4_HashRow.mois_id = row4.mois_id;

						row4_HashRow.BK_date = row4.BK_date;

						row4_HashRow.heure = row4.heure;

						row4_HashRow.annee = row4.annee;

						row4_HashRow.mois = row4.mois;

						row4_HashRow.jour = row4.jour;

						row4_HashRow.jour_semaine = row4.jour_semaine;

						row4_HashRow.est_weekend = row4.est_weekend;

						row4_HashRow.periode = row4.periode;

						tHash_Lookup_row4.put(row4_HashRow);

						tos_count_tAdvancedHash_row4++;

						/**
						 * [tAdvancedHash_row4 main ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int zone_id;

		public int getZone_id() {
			return this.zone_id;
		}

		public String zone_nom;

		public String getZone_nom() {
			return this.zone_nom;
		}

		public String ville;

		public String getVille() {
			return this.ville;
		}

		public String region;

		public String getRegion() {
			return this.region;
		}

		public String pays;

		public String getPays() {
			return this.pays;
		}

		public String code_insee_commune;

		public String getCode_insee_commune() {
			return this.code_insee_commune;
		}

		public String lat_centre;

		public String getLat_centre() {
			return this.lat_centre;
		}

		public String lon_centre;

		public String getLon_centre() {
			return this.lon_centre;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.zone_id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row5Struct other = (row5Struct) obj;

			if (this.zone_id != other.zone_id)
				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.zone_id = this.zone_id;
			other.zone_nom = this.zone_nom;
			other.ville = this.ville;
			other.region = this.region;
			other.pays = this.pays;
			other.code_insee_commune = this.code_insee_commune;
			other.lat_centre = this.lat_centre;
			other.lon_centre = this.lon_centre;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.zone_id = this.zone_id;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.zone_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.zone_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.zone_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.zone_nom = readString(dis, ois);

				this.ville = readString(dis, ois);

				this.region = readString(dis, ois);

				this.pays = readString(dis, ois);

				this.code_insee_commune = readString(dis, ois);

				this.lat_centre = readString(dis, ois);

				this.lon_centre = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.zone_nom = readString(dis, objectIn);

				this.ville = readString(dis, objectIn);

				this.region = readString(dis, objectIn);

				this.pays = readString(dis, objectIn);

				this.code_insee_commune = readString(dis, objectIn);

				this.lat_centre = readString(dis, objectIn);

				this.lon_centre = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.zone_nom, dos, oos);

				writeString(this.ville, dos, oos);

				writeString(this.region, dos, oos);

				writeString(this.pays, dos, oos);

				writeString(this.code_insee_commune, dos, oos);

				writeString(this.lat_centre, dos, oos);

				writeString(this.lon_centre, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.zone_nom, dos, objectOut);

				writeString(this.ville, dos, objectOut);

				writeString(this.region, dos, objectOut);

				writeString(this.pays, dos, objectOut);

				writeString(this.code_insee_commune, dos, objectOut);

				writeString(this.lat_centre, dos, objectOut);

				writeString(this.lon_centre, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + String.valueOf(zone_id));
			sb.append(",zone_nom=" + zone_nom);
			sb.append(",ville=" + ville);
			sb.append(",region=" + region);
			sb.append(",pays=" + pays);
			sb.append(",code_insee_commune=" + code_insee_commune);
			sb.append(",lat_centre=" + lat_centre);
			sb.append(",lon_centre=" + lon_centre);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.zone_id, other.zone_id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row5Struct row5 = new row5Struct();

				/**
				 * [tAdvancedHash_row5 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row5", false);
				start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tAdvancedHash_row5 = 0;

				// connection name:row5
				// source node:tDBInput_5 - inputs:(after_tDBInput_3) outputs:(row5,row5) |
				// target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(out1,out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row5Struct>getLookup(matchingModeEnum_row5);

				globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);

				/**
				 * [tAdvancedHash_row5 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				int tos_count_tDBInput_5 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_5 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5);
				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "miming";

				final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:0UoXHbmIEu3hJHYT9v7ZDqQp3Jut37rpS66XFkNWAAGa5Q==");

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String port_tDBInput_5 = "1433";
				String dbname_tDBInput_5 = "dwurbanmobility";
				String url_tDBInput_5 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_5)) {
					url_tDBInput_5 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_5)) {
					url_tDBInput_5 += ";databaseName=" + "dwurbanmobility";
				}
				url_tDBInput_5 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_5 = "";

				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, dbUser_tDBInput_5,
						dbPwd_tDBInput_5);

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "SELECT dimzones.zone_id,\n		dimzones.zone_nom,\n		dimzones.ville,\n		dimzones.region,\n		dimzones.pays,\n		dimzones.code_ins"
						+ "ee_commune,\n		dimzones.lat_centre,\n		dimzones.lon_centre\nFROM	dimzones";

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);
				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row5.zone_id = 0;
						} else {

							row5.zone_id = rs_tDBInput_5.getInt(1);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row5.zone_nom = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.zone_nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.zone_nom = tmpContent_tDBInput_5;
								}
							} else {
								row5.zone_nom = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 3) {
							row5.ville = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(3);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.ville = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.ville = tmpContent_tDBInput_5;
								}
							} else {
								row5.ville = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 4) {
							row5.region = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(4);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.region = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.region = tmpContent_tDBInput_5;
								}
							} else {
								row5.region = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 5) {
							row5.pays = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(5);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.pays = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.pays = tmpContent_tDBInput_5;
								}
							} else {
								row5.pays = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 6) {
							row5.code_insee_commune = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(6);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.code_insee_commune = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.code_insee_commune = tmpContent_tDBInput_5;
								}
							} else {
								row5.code_insee_commune = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 7) {
							row5.lat_centre = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(7);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.lat_centre = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.lat_centre = tmpContent_tDBInput_5;
								}
							} else {
								row5.lat_centre = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 8) {
							row5.lon_centre = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(8);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.lon_centre = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.lon_centre = tmpContent_tDBInput_5;
								}
							} else {
								row5.lon_centre = null;
							}
						}

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 main ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row5"

							);
						}

						row5Struct row5_HashRow = new row5Struct();

						row5_HashRow.zone_id = row5.zone_id;

						row5_HashRow.zone_nom = row5.zone_nom;

						row5_HashRow.ville = row5.ville;

						row5_HashRow.region = row5.region;

						row5_HashRow.pays = row5.pays;

						row5_HashRow.code_insee_commune = row5.code_insee_commune;

						row5_HashRow.lat_centre = row5.lat_centre;

						row5_HashRow.lon_centre = row5.lon_centre;

						tHash_Lookup_row5.put(row5_HashRow);

						tos_count_tAdvancedHash_row5++;

						/**
						 * [tAdvancedHash_row5 main ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_row5 end ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				tHash_Lookup_row5.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tAdvancedHash_row5", true);
				end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row5 finally ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				/**
				 * [tAdvancedHash_row5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_dimevenements = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_dimevenements = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String a_evenement;

		public String getA_evenement() {
			return this.a_evenement;
		}

		public String type_evenement;

		public String getType_evenement() {
			return this.type_evenement;
		}

		public String nom_evenement;

		public String getNom_evenement() {
			return this.nom_evenement;
		}

		public String impact_trafic;

		public String getImpact_trafic() {
			return this.impact_trafic;
		}

		public String type_vacances;

		public String getType_vacances() {
			return this.type_vacances;
		}

		public String en_vacances;

		public String getEn_vacances() {
			return this.en_vacances;
		}

		public String zone_scolaire;

		public String getZone_scolaire() {
			return this.zone_scolaire;
		}

		public String jours_feries_noms;

		public String getJours_feries_noms() {
			return this.jours_feries_noms;
		}

		public int fkzone_id;

		public int getFkzone_id() {
			return this.fkzone_id;
		}

		public int fkmois_id;

		public int getFkmois_id() {
			return this.fkmois_id;
		}

		public Integer skevent;

		public Integer getSkevent() {
			return this.skevent;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.fkzone_id;

				result = prime * result + (int) this.fkmois_id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row6Struct other = (row6Struct) obj;

			if (this.fkzone_id != other.fkzone_id)
				return false;

			if (this.fkmois_id != other.fkmois_id)
				return false;

			return true;
		}

		public void copyDataTo(row6Struct other) {

			other.a_evenement = this.a_evenement;
			other.type_evenement = this.type_evenement;
			other.nom_evenement = this.nom_evenement;
			other.impact_trafic = this.impact_trafic;
			other.type_vacances = this.type_vacances;
			other.en_vacances = this.en_vacances;
			other.zone_scolaire = this.zone_scolaire;
			other.jours_feries_noms = this.jours_feries_noms;
			other.fkzone_id = this.fkzone_id;
			other.fkmois_id = this.fkmois_id;
			other.skevent = this.skevent;

		}

		public void copyKeysDataTo(row6Struct other) {

			other.fkzone_id = this.fkzone_id;
			other.fkmois_id = this.fkmois_id;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.fkzone_id = dis.readInt();

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_dimevenements) {

				try {

					int length = 0;

					this.fkzone_id = dis.readInt();

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.fkzone_id);

				// int

				dos.writeInt(this.fkmois_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.fkzone_id);

				// int

				dos.writeInt(this.fkmois_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.a_evenement = readString(dis, ois);

				this.type_evenement = readString(dis, ois);

				this.nom_evenement = readString(dis, ois);

				this.impact_trafic = readString(dis, ois);

				this.type_vacances = readString(dis, ois);

				this.en_vacances = readString(dis, ois);

				this.zone_scolaire = readString(dis, ois);

				this.jours_feries_noms = readString(dis, ois);

				this.skevent = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.a_evenement = readString(dis, objectIn);

				this.type_evenement = readString(dis, objectIn);

				this.nom_evenement = readString(dis, objectIn);

				this.impact_trafic = readString(dis, objectIn);

				this.type_vacances = readString(dis, objectIn);

				this.en_vacances = readString(dis, objectIn);

				this.zone_scolaire = readString(dis, objectIn);

				this.jours_feries_noms = readString(dis, objectIn);

				this.skevent = readInteger(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.a_evenement, dos, oos);

				writeString(this.type_evenement, dos, oos);

				writeString(this.nom_evenement, dos, oos);

				writeString(this.impact_trafic, dos, oos);

				writeString(this.type_vacances, dos, oos);

				writeString(this.en_vacances, dos, oos);

				writeString(this.zone_scolaire, dos, oos);

				writeString(this.jours_feries_noms, dos, oos);

				writeInteger(this.skevent, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.a_evenement, dos, objectOut);

				writeString(this.type_evenement, dos, objectOut);

				writeString(this.nom_evenement, dos, objectOut);

				writeString(this.impact_trafic, dos, objectOut);

				writeString(this.type_vacances, dos, objectOut);

				writeString(this.en_vacances, dos, objectOut);

				writeString(this.zone_scolaire, dos, objectOut);

				writeString(this.jours_feries_noms, dos, objectOut);

				writeInteger(this.skevent, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("a_evenement=" + a_evenement);
			sb.append(",type_evenement=" + type_evenement);
			sb.append(",nom_evenement=" + nom_evenement);
			sb.append(",impact_trafic=" + impact_trafic);
			sb.append(",type_vacances=" + type_vacances);
			sb.append(",en_vacances=" + en_vacances);
			sb.append(",zone_scolaire=" + zone_scolaire);
			sb.append(",jours_feries_noms=" + jours_feries_noms);
			sb.append(",fkzone_id=" + String.valueOf(fkzone_id));
			sb.append(",fkmois_id=" + String.valueOf(fkmois_id));
			sb.append(",skevent=" + String.valueOf(skevent));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.fkzone_id, other.fkzone_id);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.fkmois_id, other.fkmois_id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row6Struct row6 = new row6Struct();

				/**
				 * [tAdvancedHash_row6 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row6", false);
				start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tAdvancedHash_row6 = 0;

				// connection name:row6
				// source node:tDBInput_6 - inputs:(after_tDBInput_3) outputs:(row6,row6) |
				// target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(out1,out2)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row6Struct>getLookup(matchingModeEnum_row6);

				globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);

				/**
				 * [tAdvancedHash_row6 begin ] stop
				 */

				/**
				 * [tDBInput_6 begin ] start
				 */

				ok_Hash.put("tDBInput_6", false);
				start_Hash.put("tDBInput_6", System.currentTimeMillis());

				currentComponent = "tDBInput_6";

				int tos_count_tDBInput_6 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_6 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_6 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_6 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_6, talendToDBArray_tDBInput_6);
				int nb_line_tDBInput_6 = 0;
				java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "miming";

				final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:cmmR9EIpjGmy3sEAwe2BV2shpAJj3+HaEE22RmutTQ/rRQ==");

				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;

				String port_tDBInput_6 = "1433";
				String dbname_tDBInput_6 = "dwurbanmobility";
				String url_tDBInput_6 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_6)) {
					url_tDBInput_6 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_6)) {
					url_tDBInput_6 += ";databaseName=" + "dwurbanmobility";
				}
				url_tDBInput_6 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_6 = "";

				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6, dbUser_tDBInput_6,
						dbPwd_tDBInput_6);

				java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

				String dbquery_tDBInput_6 = "SELECT dimevents.a_evenement,\n		dimevents.type_evenement,\n		dimevents.nom_evenement,\n		dimevents.impact_trafic,\n		dimev"
						+ "ents.type_vacances,\n		dimevents.en_vacances,\n		dimevents.zone_scolaire,\n		dimevents.jours_feries_noms,\n		dimevents.fkzon"
						+ "e_id,\n		dimevents.fkmois_id,\n		dimevents.skevent\nFROM	dimevents";

				globalMap.put("tDBInput_6_QUERY", dbquery_tDBInput_6);
				java.sql.ResultSet rs_tDBInput_6 = null;

				try {
					rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
					java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
					int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

					String tmpContent_tDBInput_6 = null;

					while (rs_tDBInput_6.next()) {
						nb_line_tDBInput_6++;

						if (colQtyInRs_tDBInput_6 < 1) {
							row6.a_evenement = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(1);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.a_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.a_evenement = tmpContent_tDBInput_6;
								}
							} else {
								row6.a_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 2) {
							row6.type_evenement = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(2);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.type_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.type_evenement = tmpContent_tDBInput_6;
								}
							} else {
								row6.type_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 3) {
							row6.nom_evenement = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(3);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.nom_evenement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.nom_evenement = tmpContent_tDBInput_6;
								}
							} else {
								row6.nom_evenement = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 4) {
							row6.impact_trafic = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(4);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.impact_trafic = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.impact_trafic = tmpContent_tDBInput_6;
								}
							} else {
								row6.impact_trafic = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 5) {
							row6.type_vacances = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(5);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.type_vacances = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.type_vacances = tmpContent_tDBInput_6;
								}
							} else {
								row6.type_vacances = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 6) {
							row6.en_vacances = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(6);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.en_vacances = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.en_vacances = tmpContent_tDBInput_6;
								}
							} else {
								row6.en_vacances = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 7) {
							row6.zone_scolaire = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(7);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.zone_scolaire = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.zone_scolaire = tmpContent_tDBInput_6;
								}
							} else {
								row6.zone_scolaire = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 8) {
							row6.jours_feries_noms = null;
						} else {

							tmpContent_tDBInput_6 = rs_tDBInput_6.getString(8);
							if (tmpContent_tDBInput_6 != null) {
								if (talendToDBList_tDBInput_6.contains(
										rsmd_tDBInput_6.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row6.jours_feries_noms = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
								} else {
									row6.jours_feries_noms = tmpContent_tDBInput_6;
								}
							} else {
								row6.jours_feries_noms = null;
							}
						}
						if (colQtyInRs_tDBInput_6 < 9) {
							row6.fkzone_id = 0;
						} else {

							row6.fkzone_id = rs_tDBInput_6.getInt(9);
							if (rs_tDBInput_6.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_6 < 10) {
							row6.fkmois_id = 0;
						} else {

							row6.fkmois_id = rs_tDBInput_6.getInt(10);
							if (rs_tDBInput_6.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_6 < 11) {
							row6.skevent = null;
						} else {

							row6.skevent = rs_tDBInput_6.getInt(11);
							if (rs_tDBInput_6.wasNull()) {
								row6.skevent = null;
							}
						}

						/**
						 * [tDBInput_6 begin ] stop
						 */

						/**
						 * [tDBInput_6 main ] start
						 */

						currentComponent = "tDBInput_6";

						tos_count_tDBInput_6++;

						/**
						 * [tDBInput_6 main ] stop
						 */

						/**
						 * [tDBInput_6 process_data_begin ] start
						 */

						currentComponent = "tDBInput_6";

						/**
						 * [tDBInput_6 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 main ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row6"

							);
						}

						row6Struct row6_HashRow = new row6Struct();

						row6_HashRow.a_evenement = row6.a_evenement;

						row6_HashRow.type_evenement = row6.type_evenement;

						row6_HashRow.nom_evenement = row6.nom_evenement;

						row6_HashRow.impact_trafic = row6.impact_trafic;

						row6_HashRow.type_vacances = row6.type_vacances;

						row6_HashRow.en_vacances = row6.en_vacances;

						row6_HashRow.zone_scolaire = row6.zone_scolaire;

						row6_HashRow.jours_feries_noms = row6.jours_feries_noms;

						row6_HashRow.fkzone_id = row6.fkzone_id;

						row6_HashRow.fkmois_id = row6.fkmois_id;

						row6_HashRow.skevent = row6.skevent;

						tHash_Lookup_row6.put(row6_HashRow);

						tos_count_tAdvancedHash_row6++;

						/**
						 * [tAdvancedHash_row6 main ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 process_data_end ] start
						 */

						currentComponent = "tDBInput_6";

						/**
						 * [tDBInput_6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_6 end ] start
						 */

						currentComponent = "tDBInput_6";

					}
				} finally {
					if (rs_tDBInput_6 != null) {
						rs_tDBInput_6.close();
					}
					if (stmt_tDBInput_6 != null) {
						stmt_tDBInput_6.close();
					}
					if (conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {

						conn_tDBInput_6.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_6_NB_LINE", nb_line_tDBInput_6);

				ok_Hash.put("tDBInput_6", true);
				end_Hash.put("tDBInput_6", System.currentTimeMillis());

				/**
				 * [tDBInput_6 end ] stop
				 */

				/**
				 * [tAdvancedHash_row6 end ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				tHash_Lookup_row6.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tAdvancedHash_row6", true);
				end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row6 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_6 finally ] start
				 */

				currentComponent = "tDBInput_6";

				/**
				 * [tDBInput_6 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row6 finally ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				/**
				 * [tAdvancedHash_row6 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final dimevenements dimevenementsClass = new dimevenements();

		int exitCode = dimevenementsClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = dimevenements.class.getClassLoader()
					.getResourceAsStream("local_project/dimevenements_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = dimevenements.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_3) {
			globalMap.put("tDBInput_3_SUBPROCESS_STATE", -1);

			e_tDBInput_3.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out
					.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : dimevenements");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 271120 characters generated by Talend Open Studio for Data Integration on the
 * 1 mars 2026 à 14:18:41 WAT
 ************************************************************************************************/