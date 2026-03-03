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

package local_project.loadarretstostaging_0_1;

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
 * Job: loadarretstostaging Purpose: <br>
 * Description: charge le fichier arrets.csv dans staging.raw_arrets <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class loadarretstostaging implements TalendJob {

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
	private final String jobName = "loadarretstostaging";
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
					loadarretstostaging.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(loadarretstostaging.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_9_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_9_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_10_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_10_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_10_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_10_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_11_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_11_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_11_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_11_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_7_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_8_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_9_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_10_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_11_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String stop_id;

		public String getStop_id() {
			return this.stop_id;
		}

		public String stop_nom;

		public String getStop_nom() {
			return this.stop_nom;
		}

		public String lat;

		public String getLat() {
			return this.lat;
		}

		public String lon;

		public String getLon() {
			return this.lon;
		}

		public String ville;

		public String getVille() {
			return this.ville;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String accessibilite;

		public String getAccessibilite() {
			return this.accessibilite;
		}

		public String opened_date;

		public String getOpened_date() {
			return this.opened_date;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.stop_id = readString(dis);

					this.stop_nom = readString(dis);

					this.lat = readString(dis);

					this.lon = readString(dis);

					this.ville = readString(dis);

					this.zone_id = readString(dis);

					this.accessibilite = readString(dis);

					this.opened_date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.stop_id = readString(dis);

					this.stop_nom = readString(dis);

					this.lat = readString(dis);

					this.lon = readString(dis);

					this.ville = readString(dis);

					this.zone_id = readString(dis);

					this.accessibilite = readString(dis);

					this.opened_date = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.stop_id, dos);

				// String

				writeString(this.stop_nom, dos);

				// String

				writeString(this.lat, dos);

				// String

				writeString(this.lon, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.accessibilite, dos);

				// String

				writeString(this.opened_date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.stop_id, dos);

				// String

				writeString(this.stop_nom, dos);

				// String

				writeString(this.lat, dos);

				// String

				writeString(this.lon, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.accessibilite, dos);

				// String

				writeString(this.opened_date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("stop_id=" + stop_id);
			sb.append(",stop_nom=" + stop_nom);
			sb.append(",lat=" + lat);
			sb.append(",lon=" + lon);
			sb.append(",ville=" + ville);
			sb.append(",zone_id=" + zone_id);
			sb.append(",accessibilite=" + accessibilite);
			sb.append(",opened_date=" + opened_date);
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

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

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

				row1Struct row1 = new row1Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
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
				dbschema_tDBOutput_1 = "dbo";
				String driverClass_tDBOutput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String port_tDBOutput_1 = "1433";
				String dbname_tDBOutput_1 = "UrbanMobility";
				String url_tDBOutput_1 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_1)) {
					url_tDBOutput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_1)) {
					url_tDBOutput_1 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_1 = "miming";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:ZRauL3Uga5u7VsYPUuIDCrDNjDUDyQVrXAZRt6ntquIr6g==");

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
					tableName_tDBOutput_1 = "staging_arrets";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "staging_arrets";
				}
				int count_tDBOutput_1 = 0;

				int rsTruncCountNumber_tDBOutput_1 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_1 = stmtTruncCount_tDBOutput_1
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "]")) {
						if (rsTruncCount_tDBOutput_1.next()) {
							rsTruncCountNumber_tDBOutput_1 = rsTruncCount_tDBOutput_1.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtTrunc_tDBOutput_1.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_1 + "]");
					deletedCount_tDBOutput_1 += rsTruncCountNumber_tDBOutput_1;
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([stop_id],[stop_nom],[lat],[lon],[ville],[zone_id],[accessibilite],[opened_date]) VALUES (?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				int footer_tFileInputDelimited_1 = 0;
				int totalLinetFileInputDelimited_1 = 0;
				int limittFileInputDelimited_1 = -1;
				int lastLinetFileInputDelimited_1 = -1;

				char fieldSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_1 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_1[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_1 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_1 = /** Start field tFileInputDelimited_1:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/arrets.csv"/**
																				 * End field
																				 * tFileInputDelimited_1:FILENAME
																				 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_1 = null;

				try {

					String[] rowtFileInputDelimited_1 = null;
					int currentLinetFileInputDelimited_1 = 0;
					int outputLinetFileInputDelimited_1 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_1 = 0;
							if (footer_value_tFileInputDelimited_1 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_1,
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						} else {
							csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_1),
									fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
						}

						csvReadertFileInputDelimited_1.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
							csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

						csvReadertFileInputDelimited_1.setQuoteChar('"');

						csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						if (footer_tFileInputDelimited_1 > 0) {
							for (totalLinetFileInputDelimited_1 = 0; totalLinetFileInputDelimited_1 < 1; totalLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
							csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_1.readNext()) {

								rowtFileInputDelimited_1 = csvReadertFileInputDelimited_1.getValues();
								if (!(rowtFileInputDelimited_1.length == 1
										&& ("\015").equals(rowtFileInputDelimited_1[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_1++;

								}

							}
							int lastLineTemptFileInputDelimited_1 = totalLinetFileInputDelimited_1
									- footer_tFileInputDelimited_1 < 0 ? 0
											: totalLinetFileInputDelimited_1 - footer_tFileInputDelimited_1;
							if (lastLinetFileInputDelimited_1 > 0) {
								lastLinetFileInputDelimited_1 = lastLinetFileInputDelimited_1 < lastLineTemptFileInputDelimited_1
										? lastLinetFileInputDelimited_1
										: lastLineTemptFileInputDelimited_1;
							} else {
								lastLinetFileInputDelimited_1 = lastLineTemptFileInputDelimited_1;
							}

							csvReadertFileInputDelimited_1.close();
							if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_1,
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							} else {
								csvReadertFileInputDelimited_1 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_1),
										fieldSeparator_tFileInputDelimited_1[0], "UTF-8");
							}
							csvReadertFileInputDelimited_1.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_1[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_1[0] != '\r'))
								csvReadertFileInputDelimited_1.setLineEnd("" + rowSeparator_tFileInputDelimited_1[0]);

							csvReadertFileInputDelimited_1.setQuoteChar('"');

							csvReadertFileInputDelimited_1.setEscapeChar(csvReadertFileInputDelimited_1.getQuoteChar());

						}

						if (limittFileInputDelimited_1 != 0) {
							for (currentLinetFileInputDelimited_1 = 0; currentLinetFileInputDelimited_1 < 1; currentLinetFileInputDelimited_1++) {
								csvReadertFileInputDelimited_1.readNext();
							}
						}
						csvReadertFileInputDelimited_1.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_1 != 0 && csvReadertFileInputDelimited_1 != null
							&& csvReadertFileInputDelimited_1.readNext()) {
						rowstate_tFileInputDelimited_1.reset();

						rowtFileInputDelimited_1 = csvReadertFileInputDelimited_1.getValues();

						if (rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])) {// empty
																													// line
																													// when
																													// row
																													// separator
																													// is
																													// '\n'
							continue;
						}

						currentLinetFileInputDelimited_1++;

						if (lastLinetFileInputDelimited_1 > -1
								&& currentLinetFileInputDelimited_1 > lastLinetFileInputDelimited_1) {
							break;
						}
						outputLinetFileInputDelimited_1++;
						if (limittFileInputDelimited_1 > 0
								&& outputLinetFileInputDelimited_1 > limittFileInputDelimited_1) {
							break;
						}

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							char fieldSeparator_tFileInputDelimited_1_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_1_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_1.length == 1 && ("\015").equals(rowtFileInputDelimited_1[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row1.stop_id = null;

								row1.stop_nom = null;

								row1.lat = null;

								row1.lon = null;

								row1.ville = null;

								row1.zone_id = null;

								row1.accessibilite = null;

								row1.opened_date = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_1 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_1 = 0;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.stop_id = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.stop_id = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 1;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.stop_nom = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.stop_nom = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 2;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.lat = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.lat = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 3;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.lon = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.lon = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 4;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.ville = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.ville = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 5;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.zone_id = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.zone_id = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 6;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.accessibilite = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.accessibilite = null;

								}

								columnIndexWithD_tFileInputDelimited_1 = 7;

								if (columnIndexWithD_tFileInputDelimited_1 < rowtFileInputDelimited_1.length) {

									row1.opened_date = rowtFileInputDelimited_1[columnIndexWithD_tFileInputDelimited_1];

								} else {

									row1.opened_date = null;

								}

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row1 = null;

							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row1"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (row1.stop_id == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(1, row1.stop_id);
							}

							if (row1.stop_nom == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, row1.stop_nom);
							}

							if (row1.lat == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, row1.lat);
							}

							if (row1.lon == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, row1.lon);
							}

							if (row1.ville == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(5, row1.ville);
							}

							if (row1.zone_id == null) {
								pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(6, row1.zone_id);
							}

							if (row1.accessibilite == null) {
								pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(7, row1.accessibilite);
							}

							if (row1.opened_date == null) {
								pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(8, row1.opened_date);
							}

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

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						nb_line_tFileInputDelimited_1++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_1 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_1 != null) {
							csvReadertFileInputDelimited_1.close();
						}
					}
					if (csvReadertFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", nb_line_tFileInputDelimited_1);
					}

				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
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
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
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

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String segment_id;

		public String getSegment_id() {
			return this.segment_id;
		}

		public String line_id;

		public String getLine_id() {
			return this.line_id;
		}

		public String stopidfrom;

		public String getStopidfrom() {
			return this.stopidfrom;
		}

		public String stop_id_to;

		public String getStop_id_to() {
			return this.stop_id_to;
		}

		public String distance_m;

		public String getDistance_m() {
			return this.distance_m;
		}

		public String temps_theorique_s;

		public String getTemps_theorique_s() {
			return this.temps_theorique_s;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.segment_id = readString(dis);

					this.line_id = readString(dis);

					this.stopidfrom = readString(dis);

					this.stop_id_to = readString(dis);

					this.distance_m = readString(dis);

					this.temps_theorique_s = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.segment_id = readString(dis);

					this.line_id = readString(dis);

					this.stopidfrom = readString(dis);

					this.stop_id_to = readString(dis);

					this.distance_m = readString(dis);

					this.temps_theorique_s = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.segment_id, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.stopidfrom, dos);

				// String

				writeString(this.stop_id_to, dos);

				// String

				writeString(this.distance_m, dos);

				// String

				writeString(this.temps_theorique_s, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.segment_id, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.stopidfrom, dos);

				// String

				writeString(this.stop_id_to, dos);

				// String

				writeString(this.distance_m, dos);

				// String

				writeString(this.temps_theorique_s, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("segment_id=" + segment_id);
			sb.append(",line_id=" + line_id);
			sb.append(",stopidfrom=" + stopidfrom);
			sb.append(",stop_id_to=" + stop_id_to);
			sb.append(",distance_m=" + distance_m);
			sb.append(",temps_theorique_s=" + temps_theorique_s);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

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

	public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_4 begin ] start
				 */

				ok_Hash.put("tDBOutput_4", false);
				start_Hash.put("tDBOutput_4", System.currentTimeMillis());

				currentComponent = "tDBOutput_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tDBOutput_4 = 0;

				int nb_line_tDBOutput_4 = 0;
				int nb_line_update_tDBOutput_4 = 0;
				int nb_line_inserted_tDBOutput_4 = 0;
				int nb_line_deleted_tDBOutput_4 = 0;
				int nb_line_rejected_tDBOutput_4 = 0;

				int deletedCount_tDBOutput_4 = 0;
				int updatedCount_tDBOutput_4 = 0;
				int insertedCount_tDBOutput_4 = 0;
				int rowsToCommitCount_tDBOutput_4 = 0;
				int rejectedCount_tDBOutput_4 = 0;
				String dbschema_tDBOutput_4 = null;
				String tableName_tDBOutput_4 = null;
				boolean whetherReject_tDBOutput_4 = false;

				java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
				long year1_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_4;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_4 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_4 = null;
				String dbUser_tDBOutput_4 = null;
				dbschema_tDBOutput_4 = "dbo";
				String driverClass_tDBOutput_4 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_4);
				String port_tDBOutput_4 = "1433";
				String dbname_tDBOutput_4 = "UrbanMobility";
				String url_tDBOutput_4 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_4)) {
					url_tDBOutput_4 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_4)) {
					url_tDBOutput_4 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_4 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_4 = "miming";

				final String decryptedPassword_tDBOutput_4 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:WXBMVNgHgddNA10V2DIqczS/IfDi1fUf5Ch429h1Z1E89w==");

				String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
				conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4,
						dbPwd_tDBOutput_4);

				resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);

				conn_tDBOutput_4.setAutoCommit(false);
				int commitEvery_tDBOutput_4 = 10000;
				int commitCounter_tDBOutput_4 = 0;

				int batchSize_tDBOutput_4 = 10000;
				int batchSizeCounter_tDBOutput_4 = 0;

				if (dbschema_tDBOutput_4 == null || dbschema_tDBOutput_4.trim().length() == 0) {
					tableName_tDBOutput_4 = "staging_segments";
				} else {
					tableName_tDBOutput_4 = dbschema_tDBOutput_4 + "].[" + "staging_segments";
				}
				int count_tDBOutput_4 = 0;

				int rsTruncCountNumber_tDBOutput_4 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_4 = stmtTruncCount_tDBOutput_4
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_4 + "]")) {
						if (rsTruncCount_tDBOutput_4.next()) {
							rsTruncCountNumber_tDBOutput_4 = rsTruncCount_tDBOutput_4.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
					stmtTrunc_tDBOutput_4.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_4 + "]");
					deletedCount_tDBOutput_4 += rsTruncCountNumber_tDBOutput_4;
				}
				String insert_tDBOutput_4 = "INSERT INTO [" + tableName_tDBOutput_4
						+ "] ([segment_id],[line_id],[stopidfrom],[stop_id_to],[distance_m],[temps_theorique_s]) VALUES (?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
				resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);

				/**
				 * [tDBOutput_4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_4 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_4", false);
				start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_4";

				int tos_count_tFileInputDelimited_4 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_4 = 0;
				int footer_tFileInputDelimited_4 = 0;
				int totalLinetFileInputDelimited_4 = 0;
				int limittFileInputDelimited_4 = -1;
				int lastLinetFileInputDelimited_4 = -1;

				char fieldSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_4 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_4 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_4 = /** Start field tFileInputDelimited_4:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/segments.csv"/**
																					 * End field
																					 * tFileInputDelimited_4:FILENAME
																					 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_4 = null;

				try {

					String[] rowtFileInputDelimited_4 = null;
					int currentLinetFileInputDelimited_4 = 0;
					int outputLinetFileInputDelimited_4 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_4 = 0;
							if (footer_value_tFileInputDelimited_4 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_4,
									fieldSeparator_tFileInputDelimited_4[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_4),
									fieldSeparator_tFileInputDelimited_4[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_4.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
							csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

						csvReadertFileInputDelimited_4.setQuoteChar('"');

						csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						if (footer_tFileInputDelimited_4 > 0) {
							for (totalLinetFileInputDelimited_4 = 0; totalLinetFileInputDelimited_4 < 1; totalLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
							csvReadertFileInputDelimited_4.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_4.readNext()) {

								rowtFileInputDelimited_4 = csvReadertFileInputDelimited_4.getValues();
								if (!(rowtFileInputDelimited_4.length == 1
										&& ("\015").equals(rowtFileInputDelimited_4[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_4++;

								}

							}
							int lastLineTemptFileInputDelimited_4 = totalLinetFileInputDelimited_4
									- footer_tFileInputDelimited_4 < 0 ? 0
											: totalLinetFileInputDelimited_4 - footer_tFileInputDelimited_4;
							if (lastLinetFileInputDelimited_4 > 0) {
								lastLinetFileInputDelimited_4 = lastLinetFileInputDelimited_4 < lastLineTemptFileInputDelimited_4
										? lastLinetFileInputDelimited_4
										: lastLineTemptFileInputDelimited_4;
							} else {
								lastLinetFileInputDelimited_4 = lastLineTemptFileInputDelimited_4;
							}

							csvReadertFileInputDelimited_4.close();
							if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_4,
										fieldSeparator_tFileInputDelimited_4[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_4),
										fieldSeparator_tFileInputDelimited_4[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_4.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
								csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

							csvReadertFileInputDelimited_4.setQuoteChar('"');

							csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						}

						if (limittFileInputDelimited_4 != 0) {
							for (currentLinetFileInputDelimited_4 = 0; currentLinetFileInputDelimited_4 < 1; currentLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
						}
						csvReadertFileInputDelimited_4.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_4 != 0 && csvReadertFileInputDelimited_4 != null
							&& csvReadertFileInputDelimited_4.readNext()) {
						rowstate_tFileInputDelimited_4.reset();

						rowtFileInputDelimited_4 = csvReadertFileInputDelimited_4.getValues();

						if (rowtFileInputDelimited_4.length == 1 && ("\015").equals(rowtFileInputDelimited_4[0])) {// empty
																													// line
																													// when
																													// row
																													// separator
																													// is
																													// '\n'
							continue;
						}

						currentLinetFileInputDelimited_4++;

						if (lastLinetFileInputDelimited_4 > -1
								&& currentLinetFileInputDelimited_4 > lastLinetFileInputDelimited_4) {
							break;
						}
						outputLinetFileInputDelimited_4++;
						if (limittFileInputDelimited_4 > 0
								&& outputLinetFileInputDelimited_4 > limittFileInputDelimited_4) {
							break;
						}

						row2 = null;

						boolean whetherReject_tFileInputDelimited_4 = false;
						row2 = new row2Struct();
						try {

							char fieldSeparator_tFileInputDelimited_4_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_4_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_4.length == 1 && ("\015").equals(rowtFileInputDelimited_4[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row2.segment_id = null;

								row2.line_id = null;

								row2.stopidfrom = null;

								row2.stop_id_to = null;

								row2.distance_m = null;

								row2.temps_theorique_s = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_4 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_4 = 0;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.segment_id = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.segment_id = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 1;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.line_id = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.line_id = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 2;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.stopidfrom = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.stopidfrom = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 3;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.stop_id_to = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.stop_id_to = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 4;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.distance_m = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.distance_m = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 5;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row2.temps_theorique_s = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row2.temps_theorique_s = null;

								}

							}

							if (rowstate_tFileInputDelimited_4.getException() != null) {
								throw rowstate_tFileInputDelimited_4.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_4 = true;

							System.err.println(e.getMessage());
							row2 = null;

							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_4 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_4 main ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						tos_count_tFileInputDelimited_4++;

						/**
						 * [tFileInputDelimited_4 main ] stop
						 */

						/**
						 * [tFileInputDelimited_4 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {

							/**
							 * [tDBOutput_4 main ] start
							 */

							currentComponent = "tDBOutput_4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							whetherReject_tDBOutput_4 = false;
							if (row2.segment_id == null) {
								pstmt_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(1, row2.segment_id);
							}

							if (row2.line_id == null) {
								pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(2, row2.line_id);
							}

							if (row2.stopidfrom == null) {
								pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(3, row2.stopidfrom);
							}

							if (row2.stop_id_to == null) {
								pstmt_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(4, row2.stop_id_to);
							}

							if (row2.distance_m == null) {
								pstmt_tDBOutput_4.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(5, row2.distance_m);
							}

							if (row2.temps_theorique_s == null) {
								pstmt_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(6, row2.temps_theorique_s);
							}

							pstmt_tDBOutput_4.addBatch();
							nb_line_tDBOutput_4++;

							batchSizeCounter_tDBOutput_4++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_4 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_4)
										throws Exception {
									try {

										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
												break;
											}
											counter += countEach_tDBOutput_4;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_4)
										throws Exception {
									try {

										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
												break;
											}
											counter += countEach_tDBOutput_4;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_4 > 0)
									&& (batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4)) {

								insertedCount_tDBOutput_4 = new LimitBytesHelper_tDBOutput_4()
										.limitBytePart1(insertedCount_tDBOutput_4, pstmt_tDBOutput_4);
								rowsToCommitCount_tDBOutput_4 = insertedCount_tDBOutput_4;

								batchSizeCounter_tDBOutput_4 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_4++;
							if (commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {
								if ((batchSize_tDBOutput_4 > 0) && (batchSizeCounter_tDBOutput_4 > 0)) {

									insertedCount_tDBOutput_4 = new LimitBytesHelper_tDBOutput_4()
											.limitBytePart1(insertedCount_tDBOutput_4, pstmt_tDBOutput_4);

									batchSizeCounter_tDBOutput_4 = 0;
								}
								if (rowsToCommitCount_tDBOutput_4 != 0) {

								}
								conn_tDBOutput_4.commit();
								if (rowsToCommitCount_tDBOutput_4 != 0) {

									rowsToCommitCount_tDBOutput_4 = 0;
								}
								commitCounter_tDBOutput_4 = 0;
							}

							tos_count_tDBOutput_4++;

							/**
							 * [tDBOutput_4 main ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_4";

							/**
							 * [tDBOutput_4 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_end ] start
							 */

							currentComponent = "tDBOutput_4";

							/**
							 * [tDBOutput_4 process_data_end ] stop
							 */

						} // End of branch "row2"

						/**
						 * [tFileInputDelimited_4 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_4 end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						nb_line_tFileInputDelimited_4++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_4 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_4 != null) {
							csvReadertFileInputDelimited_4.close();
						}
					}
					if (csvReadertFileInputDelimited_4 != null) {
						globalMap.put("tFileInputDelimited_4_NB_LINE", nb_line_tFileInputDelimited_4);
					}

				}

				ok_Hash.put("tFileInputDelimited_4", true);
				end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_4 end ] stop
				 */

				/**
				 * [tDBOutput_4 end ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					int countSum_tDBOutput_4 = 0;
					if (pstmt_tDBOutput_4 != null && batchSizeCounter_tDBOutput_4 > 0) {

						for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
							if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
								break;
							}
							countSum_tDBOutput_4 += countEach_tDBOutput_4;
						}
						rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					}

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_4 = 0;
					for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_4 != null) {

					pstmt_tDBOutput_4.close();
					resourceMap.remove("pstmt_tDBOutput_4");

				}
				resourceMap.put("statementClosed_tDBOutput_4", true);
				if (rowsToCommitCount_tDBOutput_4 != 0) {

				}
				conn_tDBOutput_4.commit();
				if (rowsToCommitCount_tDBOutput_4 != 0) {

					rowsToCommitCount_tDBOutput_4 = 0;
				}
				commitCounter_tDBOutput_4 = 0;
				conn_tDBOutput_4.close();
				resourceMap.put("finish_tDBOutput_4", true);

				nb_line_deleted_tDBOutput_4 = nb_line_deleted_tDBOutput_4 + deletedCount_tDBOutput_4;
				nb_line_update_tDBOutput_4 = nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
				nb_line_inserted_tDBOutput_4 = nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
				nb_line_rejected_tDBOutput_4 = nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;

				globalMap.put("tDBOutput_4_NB_LINE", nb_line_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_UPDATED", nb_line_update_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_DELETED", nb_line_deleted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tDBOutput_4", true);
				end_Hash.put("tDBOutput_4", System.currentTimeMillis());

				/**
				 * [tDBOutput_4 end ] stop
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
				 * [tFileInputDelimited_4 finally ] start
				 */

				currentComponent = "tFileInputDelimited_4";

				/**
				 * [tFileInputDelimited_4 finally ] stop
				 */

				/**
				 * [tDBOutput_4 finally ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
						if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_4")) != null) {
							pstmtToClose_tDBOutput_4.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_4") == null) {
						java.sql.Connection ctn_tDBOutput_4 = null;
						if ((ctn_tDBOutput_4 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_4")) != null) {
							try {
								ctn_tDBOutput_4.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_4) {
								String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :"
										+ sqlEx_tDBOutput_4.getMessage();
								System.err.println(errorMessage_tDBOutput_4);
							}
						}
					}
				}

				/**
				 * [tDBOutput_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String trafic_id;

		public String getTrafic_id() {
			return this.trafic_id;
		}

		public String time_id;

		public String getTime_id() {
			return this.time_id;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String vitesse_kmh;

		public String getVitesse_kmh() {
			return this.vitesse_kmh;
		}

		public String temps_trajet_min;

		public String getTemps_trajet_min() {
			return this.temps_trajet_min;
		}

		public String congestion_index;

		public String getCongestion_index() {
			return this.congestion_index;
		}

		public String source_sensor;

		public String getSource_sensor() {
			return this.source_sensor;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.trafic_id = readString(dis);

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

					this.source_sensor = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.trafic_id = readString(dis);

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

					this.source_sensor = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.trafic_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

				// String

				writeString(this.source_sensor, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.trafic_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

				// String

				writeString(this.source_sensor, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("trafic_id=" + trafic_id);
			sb.append(",time_id=" + time_id);
			sb.append(",zone_id=" + zone_id);
			sb.append(",vitesse_kmh=" + vitesse_kmh);
			sb.append(",temps_trajet_min=" + temps_trajet_min);
			sb.append(",congestion_index=" + congestion_index);
			sb.append(",source_sensor=" + source_sensor);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

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

	public void tFileInputDelimited_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_7 begin ] start
				 */

				ok_Hash.put("tDBOutput_7", false);
				start_Hash.put("tDBOutput_7", System.currentTimeMillis());

				currentComponent = "tDBOutput_7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tDBOutput_7 = 0;

				int nb_line_tDBOutput_7 = 0;
				int nb_line_update_tDBOutput_7 = 0;
				int nb_line_inserted_tDBOutput_7 = 0;
				int nb_line_deleted_tDBOutput_7 = 0;
				int nb_line_rejected_tDBOutput_7 = 0;

				int deletedCount_tDBOutput_7 = 0;
				int updatedCount_tDBOutput_7 = 0;
				int insertedCount_tDBOutput_7 = 0;
				int rowsToCommitCount_tDBOutput_7 = 0;
				int rejectedCount_tDBOutput_7 = 0;
				String dbschema_tDBOutput_7 = null;
				String tableName_tDBOutput_7 = null;
				boolean whetherReject_tDBOutput_7 = false;

				java.util.Calendar calendar_tDBOutput_7 = java.util.Calendar.getInstance();
				long year1_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_7;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_7 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_7 = null;
				String dbUser_tDBOutput_7 = null;
				dbschema_tDBOutput_7 = "dbo";
				String driverClass_tDBOutput_7 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_7);
				String port_tDBOutput_7 = "1433";
				String dbname_tDBOutput_7 = "UrbanMobility";
				String url_tDBOutput_7 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_7)) {
					url_tDBOutput_7 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_7)) {
					url_tDBOutput_7 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_7 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_7 = "miming";

				final String decryptedPassword_tDBOutput_7 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:UxZ/a4hfRODTzNTXq2Izgo5zkoReb5Qtdifj9Suig+99JQ==");

				String dbPwd_tDBOutput_7 = decryptedPassword_tDBOutput_7;
				conn_tDBOutput_7 = java.sql.DriverManager.getConnection(url_tDBOutput_7, dbUser_tDBOutput_7,
						dbPwd_tDBOutput_7);

				resourceMap.put("conn_tDBOutput_7", conn_tDBOutput_7);

				conn_tDBOutput_7.setAutoCommit(false);
				int commitEvery_tDBOutput_7 = 10000;
				int commitCounter_tDBOutput_7 = 0;

				int batchSize_tDBOutput_7 = 10000;
				int batchSizeCounter_tDBOutput_7 = 0;

				if (dbschema_tDBOutput_7 == null || dbschema_tDBOutput_7.trim().length() == 0) {
					tableName_tDBOutput_7 = "staging_trafic";
				} else {
					tableName_tDBOutput_7 = dbschema_tDBOutput_7 + "].[" + "staging_trafic";
				}
				int count_tDBOutput_7 = 0;

				int rsTruncCountNumber_tDBOutput_7 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_7 = conn_tDBOutput_7.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_7 = stmtTruncCount_tDBOutput_7
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_7 + "]")) {
						if (rsTruncCount_tDBOutput_7.next()) {
							rsTruncCountNumber_tDBOutput_7 = rsTruncCount_tDBOutput_7.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_7 = conn_tDBOutput_7.createStatement()) {
					stmtTrunc_tDBOutput_7.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_7 + "]");
					deletedCount_tDBOutput_7 += rsTruncCountNumber_tDBOutput_7;
				}
				String insert_tDBOutput_7 = "INSERT INTO [" + tableName_tDBOutput_7
						+ "] ([trafic_id],[time_id],[zone_id],[vitesse_kmh],[temps_trajet_min],[congestion_index],[source_sensor]) VALUES (?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_7 = conn_tDBOutput_7.prepareStatement(insert_tDBOutput_7);
				resourceMap.put("pstmt_tDBOutput_7", pstmt_tDBOutput_7);

				/**
				 * [tDBOutput_7 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_7 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_7", false);
				start_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_7";

				int tos_count_tFileInputDelimited_7 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_7 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_7 = 0;
				int footer_tFileInputDelimited_7 = 0;
				int totalLinetFileInputDelimited_7 = 0;
				int limittFileInputDelimited_7 = -1;
				int lastLinetFileInputDelimited_7 = -1;

				char fieldSeparator_tFileInputDelimited_7[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ";").length() > 0) {
					fieldSeparator_tFileInputDelimited_7 = ((String) ";").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_7[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_7 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_7 = /** Start field tFileInputDelimited_7:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/trafic.csv"/**
																				 * End field
																				 * tFileInputDelimited_7:FILENAME
																				 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_7 = null;

				try {

					String[] rowtFileInputDelimited_7 = null;
					int currentLinetFileInputDelimited_7 = 0;
					int outputLinetFileInputDelimited_7 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_7 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_7 = 0;
							if (footer_value_tFileInputDelimited_7 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_7 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_7,
									fieldSeparator_tFileInputDelimited_7[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_7 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_7),
									fieldSeparator_tFileInputDelimited_7[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_7.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_7[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_7[0] != '\r'))
							csvReadertFileInputDelimited_7.setLineEnd("" + rowSeparator_tFileInputDelimited_7[0]);

						csvReadertFileInputDelimited_7.setQuoteChar('"');

						csvReadertFileInputDelimited_7.setEscapeChar(csvReadertFileInputDelimited_7.getQuoteChar());

						if (footer_tFileInputDelimited_7 > 0) {
							for (totalLinetFileInputDelimited_7 = 0; totalLinetFileInputDelimited_7 < 1; totalLinetFileInputDelimited_7++) {
								csvReadertFileInputDelimited_7.readNext();
							}
							csvReadertFileInputDelimited_7.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_7.readNext()) {

								rowtFileInputDelimited_7 = csvReadertFileInputDelimited_7.getValues();
								if (!(rowtFileInputDelimited_7.length == 1
										&& ("\015").equals(rowtFileInputDelimited_7[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_7++;

								}

							}
							int lastLineTemptFileInputDelimited_7 = totalLinetFileInputDelimited_7
									- footer_tFileInputDelimited_7 < 0 ? 0
											: totalLinetFileInputDelimited_7 - footer_tFileInputDelimited_7;
							if (lastLinetFileInputDelimited_7 > 0) {
								lastLinetFileInputDelimited_7 = lastLinetFileInputDelimited_7 < lastLineTemptFileInputDelimited_7
										? lastLinetFileInputDelimited_7
										: lastLineTemptFileInputDelimited_7;
							} else {
								lastLinetFileInputDelimited_7 = lastLineTemptFileInputDelimited_7;
							}

							csvReadertFileInputDelimited_7.close();
							if (filename_tFileInputDelimited_7 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_7 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_7,
										fieldSeparator_tFileInputDelimited_7[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_7 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_7),
										fieldSeparator_tFileInputDelimited_7[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_7.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_7[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_7[0] != '\r'))
								csvReadertFileInputDelimited_7.setLineEnd("" + rowSeparator_tFileInputDelimited_7[0]);

							csvReadertFileInputDelimited_7.setQuoteChar('"');

							csvReadertFileInputDelimited_7.setEscapeChar(csvReadertFileInputDelimited_7.getQuoteChar());

						}

						if (limittFileInputDelimited_7 != 0) {
							for (currentLinetFileInputDelimited_7 = 0; currentLinetFileInputDelimited_7 < 1; currentLinetFileInputDelimited_7++) {
								csvReadertFileInputDelimited_7.readNext();
							}
						}
						csvReadertFileInputDelimited_7.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_7 != 0 && csvReadertFileInputDelimited_7 != null
							&& csvReadertFileInputDelimited_7.readNext()) {
						rowstate_tFileInputDelimited_7.reset();

						rowtFileInputDelimited_7 = csvReadertFileInputDelimited_7.getValues();

						if (rowtFileInputDelimited_7.length == 1 && ("\015").equals(rowtFileInputDelimited_7[0])) {// empty
																													// line
																													// when
																													// row
																													// separator
																													// is
																													// '\n'
							continue;
						}

						currentLinetFileInputDelimited_7++;

						if (lastLinetFileInputDelimited_7 > -1
								&& currentLinetFileInputDelimited_7 > lastLinetFileInputDelimited_7) {
							break;
						}
						outputLinetFileInputDelimited_7++;
						if (limittFileInputDelimited_7 > 0
								&& outputLinetFileInputDelimited_7 > limittFileInputDelimited_7) {
							break;
						}

						row3 = null;

						boolean whetherReject_tFileInputDelimited_7 = false;
						row3 = new row3Struct();
						try {

							char fieldSeparator_tFileInputDelimited_7_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ";").length() > 0) {
								fieldSeparator_tFileInputDelimited_7_ListType = ((String) ";").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_7.length == 1 && ("\015").equals(rowtFileInputDelimited_7[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row3.trafic_id = null;

								row3.time_id = null;

								row3.zone_id = null;

								row3.vitesse_kmh = null;

								row3.temps_trajet_min = null;

								row3.congestion_index = null;

								row3.source_sensor = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_7 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_7 = 0;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.trafic_id = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.trafic_id = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 1;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.time_id = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.time_id = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 2;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.zone_id = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.zone_id = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 3;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.vitesse_kmh = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.vitesse_kmh = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 4;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.temps_trajet_min = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.temps_trajet_min = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 5;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.congestion_index = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.congestion_index = null;

								}

								columnIndexWithD_tFileInputDelimited_7 = 6;

								if (columnIndexWithD_tFileInputDelimited_7 < rowtFileInputDelimited_7.length) {

									row3.source_sensor = rowtFileInputDelimited_7[columnIndexWithD_tFileInputDelimited_7];

								} else {

									row3.source_sensor = null;

								}

							}

							if (rowstate_tFileInputDelimited_7.getException() != null) {
								throw rowstate_tFileInputDelimited_7.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_7 = true;

							System.err.println(e.getMessage());
							row3 = null;

							globalMap.put("tFileInputDelimited_7_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_7 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_7 main ] start
						 */

						currentComponent = "tFileInputDelimited_7";

						tos_count_tFileInputDelimited_7++;

						/**
						 * [tFileInputDelimited_7 main ] stop
						 */

						/**
						 * [tFileInputDelimited_7 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_7";

						/**
						 * [tFileInputDelimited_7 process_data_begin ] stop
						 */
// Start of branch "row3"
						if (row3 != null) {

							/**
							 * [tDBOutput_7 main ] start
							 */

							currentComponent = "tDBOutput_7";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							whetherReject_tDBOutput_7 = false;
							if (row3.trafic_id == null) {
								pstmt_tDBOutput_7.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(1, row3.trafic_id);
							}

							if (row3.time_id == null) {
								pstmt_tDBOutput_7.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(2, row3.time_id);
							}

							if (row3.zone_id == null) {
								pstmt_tDBOutput_7.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(3, row3.zone_id);
							}

							if (row3.vitesse_kmh == null) {
								pstmt_tDBOutput_7.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(4, row3.vitesse_kmh);
							}

							if (row3.temps_trajet_min == null) {
								pstmt_tDBOutput_7.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(5, row3.temps_trajet_min);
							}

							if (row3.congestion_index == null) {
								pstmt_tDBOutput_7.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(6, row3.congestion_index);
							}

							if (row3.source_sensor == null) {
								pstmt_tDBOutput_7.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_7.setString(7, row3.source_sensor);
							}

							pstmt_tDBOutput_7.addBatch();
							nb_line_tDBOutput_7++;

							batchSizeCounter_tDBOutput_7++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_7 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_7)
										throws Exception {
									try {

										for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
											if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
												break;
											}
											counter += countEach_tDBOutput_7;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_7 = 0;
										for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_7)
										throws Exception {
									try {

										for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
											if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
												break;
											}
											counter += countEach_tDBOutput_7;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_7 > 0)
									&& (batchSize_tDBOutput_7 <= batchSizeCounter_tDBOutput_7)) {

								insertedCount_tDBOutput_7 = new LimitBytesHelper_tDBOutput_7()
										.limitBytePart1(insertedCount_tDBOutput_7, pstmt_tDBOutput_7);
								rowsToCommitCount_tDBOutput_7 = insertedCount_tDBOutput_7;

								batchSizeCounter_tDBOutput_7 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_7++;
							if (commitEvery_tDBOutput_7 <= commitCounter_tDBOutput_7) {
								if ((batchSize_tDBOutput_7 > 0) && (batchSizeCounter_tDBOutput_7 > 0)) {

									insertedCount_tDBOutput_7 = new LimitBytesHelper_tDBOutput_7()
											.limitBytePart1(insertedCount_tDBOutput_7, pstmt_tDBOutput_7);

									batchSizeCounter_tDBOutput_7 = 0;
								}
								if (rowsToCommitCount_tDBOutput_7 != 0) {

								}
								conn_tDBOutput_7.commit();
								if (rowsToCommitCount_tDBOutput_7 != 0) {

									rowsToCommitCount_tDBOutput_7 = 0;
								}
								commitCounter_tDBOutput_7 = 0;
							}

							tos_count_tDBOutput_7++;

							/**
							 * [tDBOutput_7 main ] stop
							 */

							/**
							 * [tDBOutput_7 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_7";

							/**
							 * [tDBOutput_7 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_7 process_data_end ] start
							 */

							currentComponent = "tDBOutput_7";

							/**
							 * [tDBOutput_7 process_data_end ] stop
							 */

						} // End of branch "row3"

						/**
						 * [tFileInputDelimited_7 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_7";

						/**
						 * [tFileInputDelimited_7 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_7 end ] start
						 */

						currentComponent = "tFileInputDelimited_7";

						nb_line_tFileInputDelimited_7++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_7 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_7 != null) {
							csvReadertFileInputDelimited_7.close();
						}
					}
					if (csvReadertFileInputDelimited_7 != null) {
						globalMap.put("tFileInputDelimited_7_NB_LINE", nb_line_tFileInputDelimited_7);
					}

				}

				ok_Hash.put("tFileInputDelimited_7", true);
				end_Hash.put("tFileInputDelimited_7", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_7 end ] stop
				 */

				/**
				 * [tDBOutput_7 end ] start
				 */

				currentComponent = "tDBOutput_7";

				try {
					int countSum_tDBOutput_7 = 0;
					if (pstmt_tDBOutput_7 != null && batchSizeCounter_tDBOutput_7 > 0) {

						for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
							if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
								break;
							}
							countSum_tDBOutput_7 += countEach_tDBOutput_7;
						}
						rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;

					}

					insertedCount_tDBOutput_7 += countSum_tDBOutput_7;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_7 = 0;
					for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
						countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
					}
					rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;

					insertedCount_tDBOutput_7 += countSum_tDBOutput_7;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_7 != null) {

					pstmt_tDBOutput_7.close();
					resourceMap.remove("pstmt_tDBOutput_7");

				}
				resourceMap.put("statementClosed_tDBOutput_7", true);
				if (rowsToCommitCount_tDBOutput_7 != 0) {

				}
				conn_tDBOutput_7.commit();
				if (rowsToCommitCount_tDBOutput_7 != 0) {

					rowsToCommitCount_tDBOutput_7 = 0;
				}
				commitCounter_tDBOutput_7 = 0;
				conn_tDBOutput_7.close();
				resourceMap.put("finish_tDBOutput_7", true);

				nb_line_deleted_tDBOutput_7 = nb_line_deleted_tDBOutput_7 + deletedCount_tDBOutput_7;
				nb_line_update_tDBOutput_7 = nb_line_update_tDBOutput_7 + updatedCount_tDBOutput_7;
				nb_line_inserted_tDBOutput_7 = nb_line_inserted_tDBOutput_7 + insertedCount_tDBOutput_7;
				nb_line_rejected_tDBOutput_7 = nb_line_rejected_tDBOutput_7 + rejectedCount_tDBOutput_7;

				globalMap.put("tDBOutput_7_NB_LINE", nb_line_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_UPDATED", nb_line_update_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_DELETED", nb_line_deleted_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_7);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tDBOutput_7", true);
				end_Hash.put("tDBOutput_7", System.currentTimeMillis());

				/**
				 * [tDBOutput_7 end ] stop
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
				 * [tFileInputDelimited_7 finally ] start
				 */

				currentComponent = "tFileInputDelimited_7";

				/**
				 * [tFileInputDelimited_7 finally ] stop
				 */

				/**
				 * [tDBOutput_7 finally ] start
				 */

				currentComponent = "tDBOutput_7";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_7") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_7 = null;
						if ((pstmtToClose_tDBOutput_7 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_7")) != null) {
							pstmtToClose_tDBOutput_7.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_7") == null) {
						java.sql.Connection ctn_tDBOutput_7 = null;
						if ((ctn_tDBOutput_7 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_7")) != null) {
							try {
								ctn_tDBOutput_7.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_7) {
								String errorMessage_tDBOutput_7 = "failed to close the connection in tDBOutput_7 :"
										+ sqlEx_tDBOutput_7.getMessage();
								System.err.println(errorMessage_tDBOutput_7);
							}
						}
					}
				}

				/**
				 * [tDBOutput_7 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String event_id;

		public String getEvent_id() {
			return this.event_id;
		}

		public String time_id;

		public String getTime_id() {
			return this.time_id;
		}

		public String line_id;

		public String getLine_id() {
			return this.line_id;
		}

		public String stop_id;

		public String getStop_id() {
			return this.stop_id;
		}

		public String heure_theorique;

		public String getHeure_theorique() {
			return this.heure_theorique;
		}

		public String heure_reelle;

		public String getHeure_reelle() {
			return this.heure_reelle;
		}

		public String retard_s;

		public String getRetard_s() {
			return this.retard_s;
		}

		public String annule;

		public String getAnnule() {
			return this.annule;
		}

		public String charge_estimee;

		public String getCharge_estimee() {
			return this.charge_estimee;
		}

		public String vehicle_id;

		public String getVehicle_id() {
			return this.vehicle_id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.event_id = readString(dis);

					this.time_id = readString(dis);

					this.line_id = readString(dis);

					this.stop_id = readString(dis);

					this.heure_theorique = readString(dis);

					this.heure_reelle = readString(dis);

					this.retard_s = readString(dis);

					this.annule = readString(dis);

					this.charge_estimee = readString(dis);

					this.vehicle_id = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.event_id = readString(dis);

					this.time_id = readString(dis);

					this.line_id = readString(dis);

					this.stop_id = readString(dis);

					this.heure_theorique = readString(dis);

					this.heure_reelle = readString(dis);

					this.retard_s = readString(dis);

					this.annule = readString(dis);

					this.charge_estimee = readString(dis);

					this.vehicle_id = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.event_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.stop_id, dos);

				// String

				writeString(this.heure_theorique, dos);

				// String

				writeString(this.heure_reelle, dos);

				// String

				writeString(this.retard_s, dos);

				// String

				writeString(this.annule, dos);

				// String

				writeString(this.charge_estimee, dos);

				// String

				writeString(this.vehicle_id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.event_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.stop_id, dos);

				// String

				writeString(this.heure_theorique, dos);

				// String

				writeString(this.heure_reelle, dos);

				// String

				writeString(this.retard_s, dos);

				// String

				writeString(this.annule, dos);

				// String

				writeString(this.charge_estimee, dos);

				// String

				writeString(this.vehicle_id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("event_id=" + event_id);
			sb.append(",time_id=" + time_id);
			sb.append(",line_id=" + line_id);
			sb.append(",stop_id=" + stop_id);
			sb.append(",heure_theorique=" + heure_theorique);
			sb.append(",heure_reelle=" + heure_reelle);
			sb.append(",retard_s=" + retard_s);
			sb.append(",annule=" + annule);
			sb.append(",charge_estimee=" + charge_estimee);
			sb.append(",vehicle_id=" + vehicle_id);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

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

	public void tFileInputDelimited_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_8 begin ] start
				 */

				ok_Hash.put("tDBOutput_8", false);
				start_Hash.put("tDBOutput_8", System.currentTimeMillis());

				currentComponent = "tDBOutput_8";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tDBOutput_8 = 0;

				int nb_line_tDBOutput_8 = 0;
				int nb_line_update_tDBOutput_8 = 0;
				int nb_line_inserted_tDBOutput_8 = 0;
				int nb_line_deleted_tDBOutput_8 = 0;
				int nb_line_rejected_tDBOutput_8 = 0;

				int deletedCount_tDBOutput_8 = 0;
				int updatedCount_tDBOutput_8 = 0;
				int insertedCount_tDBOutput_8 = 0;
				int rowsToCommitCount_tDBOutput_8 = 0;
				int rejectedCount_tDBOutput_8 = 0;
				String dbschema_tDBOutput_8 = null;
				String tableName_tDBOutput_8 = null;
				boolean whetherReject_tDBOutput_8 = false;

				java.util.Calendar calendar_tDBOutput_8 = java.util.Calendar.getInstance();
				long year1_tDBOutput_8 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_8 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_8 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_8;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_8 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_8 = null;
				String dbUser_tDBOutput_8 = null;
				dbschema_tDBOutput_8 = "dbo";
				String driverClass_tDBOutput_8 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_8);
				String port_tDBOutput_8 = "1433";
				String dbname_tDBOutput_8 = "UrbanMobility";
				String url_tDBOutput_8 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_8)) {
					url_tDBOutput_8 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_8)) {
					url_tDBOutput_8 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_8 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_8 = "miming";

				final String decryptedPassword_tDBOutput_8 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:jJ3rF0uUxlluh2qDFecpObsEJ8IAbxs7KzsHjgkcAdhaJA==");

				String dbPwd_tDBOutput_8 = decryptedPassword_tDBOutput_8;
				conn_tDBOutput_8 = java.sql.DriverManager.getConnection(url_tDBOutput_8, dbUser_tDBOutput_8,
						dbPwd_tDBOutput_8);

				resourceMap.put("conn_tDBOutput_8", conn_tDBOutput_8);

				conn_tDBOutput_8.setAutoCommit(false);
				int commitEvery_tDBOutput_8 = 10000;
				int commitCounter_tDBOutput_8 = 0;

				int batchSize_tDBOutput_8 = 10000;
				int batchSizeCounter_tDBOutput_8 = 0;

				if (dbschema_tDBOutput_8 == null || dbschema_tDBOutput_8.trim().length() == 0) {
					tableName_tDBOutput_8 = "staging_transport_passages";
				} else {
					tableName_tDBOutput_8 = dbschema_tDBOutput_8 + "].[" + "staging_transport_passages";
				}
				int count_tDBOutput_8 = 0;

				int rsTruncCountNumber_tDBOutput_8 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_8 = conn_tDBOutput_8.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_8 = stmtTruncCount_tDBOutput_8
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_8 + "]")) {
						if (rsTruncCount_tDBOutput_8.next()) {
							rsTruncCountNumber_tDBOutput_8 = rsTruncCount_tDBOutput_8.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_8 = conn_tDBOutput_8.createStatement()) {
					stmtTrunc_tDBOutput_8.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_8 + "]");
					deletedCount_tDBOutput_8 += rsTruncCountNumber_tDBOutput_8;
				}
				String insert_tDBOutput_8 = "INSERT INTO [" + tableName_tDBOutput_8
						+ "] ([event_id],[time_id],[line_id],[stop_id],[heure_theorique],[heure_reelle],[retard_s],[annule],[charge_estimee],[vehicle_id]) VALUES (?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_8 = conn_tDBOutput_8.prepareStatement(insert_tDBOutput_8);
				resourceMap.put("pstmt_tDBOutput_8", pstmt_tDBOutput_8);

				/**
				 * [tDBOutput_8 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_8 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_8", false);
				start_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_8";

				int tos_count_tFileInputDelimited_8 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_8 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_8 = 0;
				int footer_tFileInputDelimited_8 = 0;
				int totalLinetFileInputDelimited_8 = 0;
				int limittFileInputDelimited_8 = -1;
				int lastLinetFileInputDelimited_8 = -1;

				char fieldSeparator_tFileInputDelimited_8[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_8 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_8[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_8 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_8 = /** Start field tFileInputDelimited_8:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/transport_passages.csv"/**
																							 * End field
																							 * tFileInputDelimited_8:FILENAME
																							 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_8 = null;

				try {

					String[] rowtFileInputDelimited_8 = null;
					int currentLinetFileInputDelimited_8 = 0;
					int outputLinetFileInputDelimited_8 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_8 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_8 = 0;
							if (footer_value_tFileInputDelimited_8 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_8 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_8,
									fieldSeparator_tFileInputDelimited_8[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_8 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_8),
									fieldSeparator_tFileInputDelimited_8[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_8.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_8[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_8[0] != '\r'))
							csvReadertFileInputDelimited_8.setLineEnd("" + rowSeparator_tFileInputDelimited_8[0]);

						csvReadertFileInputDelimited_8.setQuoteChar('"');

						csvReadertFileInputDelimited_8.setEscapeChar(csvReadertFileInputDelimited_8.getQuoteChar());

						if (footer_tFileInputDelimited_8 > 0) {
							for (totalLinetFileInputDelimited_8 = 0; totalLinetFileInputDelimited_8 < 1; totalLinetFileInputDelimited_8++) {
								csvReadertFileInputDelimited_8.readNext();
							}
							csvReadertFileInputDelimited_8.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_8.readNext()) {

								rowtFileInputDelimited_8 = csvReadertFileInputDelimited_8.getValues();
								if (!(rowtFileInputDelimited_8.length == 1
										&& ("\015").equals(rowtFileInputDelimited_8[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_8++;

								}

							}
							int lastLineTemptFileInputDelimited_8 = totalLinetFileInputDelimited_8
									- footer_tFileInputDelimited_8 < 0 ? 0
											: totalLinetFileInputDelimited_8 - footer_tFileInputDelimited_8;
							if (lastLinetFileInputDelimited_8 > 0) {
								lastLinetFileInputDelimited_8 = lastLinetFileInputDelimited_8 < lastLineTemptFileInputDelimited_8
										? lastLinetFileInputDelimited_8
										: lastLineTemptFileInputDelimited_8;
							} else {
								lastLinetFileInputDelimited_8 = lastLineTemptFileInputDelimited_8;
							}

							csvReadertFileInputDelimited_8.close();
							if (filename_tFileInputDelimited_8 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_8 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_8,
										fieldSeparator_tFileInputDelimited_8[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_8 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_8),
										fieldSeparator_tFileInputDelimited_8[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_8.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_8[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_8[0] != '\r'))
								csvReadertFileInputDelimited_8.setLineEnd("" + rowSeparator_tFileInputDelimited_8[0]);

							csvReadertFileInputDelimited_8.setQuoteChar('"');

							csvReadertFileInputDelimited_8.setEscapeChar(csvReadertFileInputDelimited_8.getQuoteChar());

						}

						if (limittFileInputDelimited_8 != 0) {
							for (currentLinetFileInputDelimited_8 = 0; currentLinetFileInputDelimited_8 < 1; currentLinetFileInputDelimited_8++) {
								csvReadertFileInputDelimited_8.readNext();
							}
						}
						csvReadertFileInputDelimited_8.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_8 != 0 && csvReadertFileInputDelimited_8 != null
							&& csvReadertFileInputDelimited_8.readNext()) {
						rowstate_tFileInputDelimited_8.reset();

						rowtFileInputDelimited_8 = csvReadertFileInputDelimited_8.getValues();

						if (rowtFileInputDelimited_8.length == 1 && ("\015").equals(rowtFileInputDelimited_8[0])) {// empty
																													// line
																													// when
																													// row
																													// separator
																													// is
																													// '\n'
							continue;
						}

						currentLinetFileInputDelimited_8++;

						if (lastLinetFileInputDelimited_8 > -1
								&& currentLinetFileInputDelimited_8 > lastLinetFileInputDelimited_8) {
							break;
						}
						outputLinetFileInputDelimited_8++;
						if (limittFileInputDelimited_8 > 0
								&& outputLinetFileInputDelimited_8 > limittFileInputDelimited_8) {
							break;
						}

						row5 = null;

						boolean whetherReject_tFileInputDelimited_8 = false;
						row5 = new row5Struct();
						try {

							char fieldSeparator_tFileInputDelimited_8_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_8_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_8.length == 1 && ("\015").equals(rowtFileInputDelimited_8[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row5.event_id = null;

								row5.time_id = null;

								row5.line_id = null;

								row5.stop_id = null;

								row5.heure_theorique = null;

								row5.heure_reelle = null;

								row5.retard_s = null;

								row5.annule = null;

								row5.charge_estimee = null;

								row5.vehicle_id = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_8 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_8 = 0;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.event_id = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.event_id = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 1;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.time_id = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.time_id = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 2;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.line_id = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.line_id = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 3;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.stop_id = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.stop_id = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 4;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.heure_theorique = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.heure_theorique = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 5;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.heure_reelle = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.heure_reelle = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 6;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.retard_s = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.retard_s = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 7;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.annule = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.annule = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 8;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.charge_estimee = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.charge_estimee = null;

								}

								columnIndexWithD_tFileInputDelimited_8 = 9;

								if (columnIndexWithD_tFileInputDelimited_8 < rowtFileInputDelimited_8.length) {

									row5.vehicle_id = rowtFileInputDelimited_8[columnIndexWithD_tFileInputDelimited_8];

								} else {

									row5.vehicle_id = null;

								}

							}

							if (rowstate_tFileInputDelimited_8.getException() != null) {
								throw rowstate_tFileInputDelimited_8.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_8 = true;

							System.err.println(e.getMessage());
							row5 = null;

							globalMap.put("tFileInputDelimited_8_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_8 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_8 main ] start
						 */

						currentComponent = "tFileInputDelimited_8";

						tos_count_tFileInputDelimited_8++;

						/**
						 * [tFileInputDelimited_8 main ] stop
						 */

						/**
						 * [tFileInputDelimited_8 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_8";

						/**
						 * [tFileInputDelimited_8 process_data_begin ] stop
						 */
// Start of branch "row5"
						if (row5 != null) {

							/**
							 * [tDBOutput_8 main ] start
							 */

							currentComponent = "tDBOutput_8";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row5"

								);
							}

							whetherReject_tDBOutput_8 = false;
							if (row5.event_id == null) {
								pstmt_tDBOutput_8.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(1, row5.event_id);
							}

							if (row5.time_id == null) {
								pstmt_tDBOutput_8.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(2, row5.time_id);
							}

							if (row5.line_id == null) {
								pstmt_tDBOutput_8.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(3, row5.line_id);
							}

							if (row5.stop_id == null) {
								pstmt_tDBOutput_8.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(4, row5.stop_id);
							}

							if (row5.heure_theorique == null) {
								pstmt_tDBOutput_8.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(5, row5.heure_theorique);
							}

							if (row5.heure_reelle == null) {
								pstmt_tDBOutput_8.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(6, row5.heure_reelle);
							}

							if (row5.retard_s == null) {
								pstmt_tDBOutput_8.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(7, row5.retard_s);
							}

							if (row5.annule == null) {
								pstmt_tDBOutput_8.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(8, row5.annule);
							}

							if (row5.charge_estimee == null) {
								pstmt_tDBOutput_8.setNull(9, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(9, row5.charge_estimee);
							}

							if (row5.vehicle_id == null) {
								pstmt_tDBOutput_8.setNull(10, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_8.setString(10, row5.vehicle_id);
							}

							pstmt_tDBOutput_8.addBatch();
							nb_line_tDBOutput_8++;

							batchSizeCounter_tDBOutput_8++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_8 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_8)
										throws Exception {
									try {

										for (int countEach_tDBOutput_8 : pstmt_tDBOutput_8.executeBatch()) {
											if (countEach_tDBOutput_8 == -2 || countEach_tDBOutput_8 == -3) {
												break;
											}
											counter += countEach_tDBOutput_8;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_8_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_8 = 0;
										for (int countEach_tDBOutput_8 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_8)
										throws Exception {
									try {

										for (int countEach_tDBOutput_8 : pstmt_tDBOutput_8.executeBatch()) {
											if (countEach_tDBOutput_8 == -2 || countEach_tDBOutput_8 == -3) {
												break;
											}
											counter += countEach_tDBOutput_8;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_8_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_8 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_8 > 0)
									&& (batchSize_tDBOutput_8 <= batchSizeCounter_tDBOutput_8)) {

								insertedCount_tDBOutput_8 = new LimitBytesHelper_tDBOutput_8()
										.limitBytePart1(insertedCount_tDBOutput_8, pstmt_tDBOutput_8);
								rowsToCommitCount_tDBOutput_8 = insertedCount_tDBOutput_8;

								batchSizeCounter_tDBOutput_8 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_8++;
							if (commitEvery_tDBOutput_8 <= commitCounter_tDBOutput_8) {
								if ((batchSize_tDBOutput_8 > 0) && (batchSizeCounter_tDBOutput_8 > 0)) {

									insertedCount_tDBOutput_8 = new LimitBytesHelper_tDBOutput_8()
											.limitBytePart1(insertedCount_tDBOutput_8, pstmt_tDBOutput_8);

									batchSizeCounter_tDBOutput_8 = 0;
								}
								if (rowsToCommitCount_tDBOutput_8 != 0) {

								}
								conn_tDBOutput_8.commit();
								if (rowsToCommitCount_tDBOutput_8 != 0) {

									rowsToCommitCount_tDBOutput_8 = 0;
								}
								commitCounter_tDBOutput_8 = 0;
							}

							tos_count_tDBOutput_8++;

							/**
							 * [tDBOutput_8 main ] stop
							 */

							/**
							 * [tDBOutput_8 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_8";

							/**
							 * [tDBOutput_8 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_8 process_data_end ] start
							 */

							currentComponent = "tDBOutput_8";

							/**
							 * [tDBOutput_8 process_data_end ] stop
							 */

						} // End of branch "row5"

						/**
						 * [tFileInputDelimited_8 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_8";

						/**
						 * [tFileInputDelimited_8 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_8 end ] start
						 */

						currentComponent = "tFileInputDelimited_8";

						nb_line_tFileInputDelimited_8++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_8 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_8 != null) {
							csvReadertFileInputDelimited_8.close();
						}
					}
					if (csvReadertFileInputDelimited_8 != null) {
						globalMap.put("tFileInputDelimited_8_NB_LINE", nb_line_tFileInputDelimited_8);
					}

				}

				ok_Hash.put("tFileInputDelimited_8", true);
				end_Hash.put("tFileInputDelimited_8", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_8 end ] stop
				 */

				/**
				 * [tDBOutput_8 end ] start
				 */

				currentComponent = "tDBOutput_8";

				try {
					int countSum_tDBOutput_8 = 0;
					if (pstmt_tDBOutput_8 != null && batchSizeCounter_tDBOutput_8 > 0) {

						for (int countEach_tDBOutput_8 : pstmt_tDBOutput_8.executeBatch()) {
							if (countEach_tDBOutput_8 == -2 || countEach_tDBOutput_8 == -3) {
								break;
							}
							countSum_tDBOutput_8 += countEach_tDBOutput_8;
						}
						rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;

					}

					insertedCount_tDBOutput_8 += countSum_tDBOutput_8;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_8_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_8 = 0;
					for (int countEach_tDBOutput_8 : e.getUpdateCounts()) {
						countSum_tDBOutput_8 += (countEach_tDBOutput_8 < 0 ? 0 : countEach_tDBOutput_8);
					}
					rowsToCommitCount_tDBOutput_8 += countSum_tDBOutput_8;

					insertedCount_tDBOutput_8 += countSum_tDBOutput_8;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_8 != null) {

					pstmt_tDBOutput_8.close();
					resourceMap.remove("pstmt_tDBOutput_8");

				}
				resourceMap.put("statementClosed_tDBOutput_8", true);
				if (rowsToCommitCount_tDBOutput_8 != 0) {

				}
				conn_tDBOutput_8.commit();
				if (rowsToCommitCount_tDBOutput_8 != 0) {

					rowsToCommitCount_tDBOutput_8 = 0;
				}
				commitCounter_tDBOutput_8 = 0;
				conn_tDBOutput_8.close();
				resourceMap.put("finish_tDBOutput_8", true);

				nb_line_deleted_tDBOutput_8 = nb_line_deleted_tDBOutput_8 + deletedCount_tDBOutput_8;
				nb_line_update_tDBOutput_8 = nb_line_update_tDBOutput_8 + updatedCount_tDBOutput_8;
				nb_line_inserted_tDBOutput_8 = nb_line_inserted_tDBOutput_8 + insertedCount_tDBOutput_8;
				nb_line_rejected_tDBOutput_8 = nb_line_rejected_tDBOutput_8 + rejectedCount_tDBOutput_8;

				globalMap.put("tDBOutput_8_NB_LINE", nb_line_tDBOutput_8);
				globalMap.put("tDBOutput_8_NB_LINE_UPDATED", nb_line_update_tDBOutput_8);
				globalMap.put("tDBOutput_8_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_8);
				globalMap.put("tDBOutput_8_NB_LINE_DELETED", nb_line_deleted_tDBOutput_8);
				globalMap.put("tDBOutput_8_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_8);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tDBOutput_8", true);
				end_Hash.put("tDBOutput_8", System.currentTimeMillis());

				/**
				 * [tDBOutput_8 end ] stop
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
				 * [tFileInputDelimited_8 finally ] start
				 */

				currentComponent = "tFileInputDelimited_8";

				/**
				 * [tFileInputDelimited_8 finally ] stop
				 */

				/**
				 * [tDBOutput_8 finally ] start
				 */

				currentComponent = "tDBOutput_8";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_8") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_8 = null;
						if ((pstmtToClose_tDBOutput_8 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_8")) != null) {
							pstmtToClose_tDBOutput_8.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_8") == null) {
						java.sql.Connection ctn_tDBOutput_8 = null;
						if ((ctn_tDBOutput_8 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_8")) != null) {
							try {
								ctn_tDBOutput_8.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_8) {
								String errorMessage_tDBOutput_8 = "failed to close the connection in tDBOutput_8 :"
										+ sqlEx_tDBOutput_8.getMessage();
								System.err.println(errorMessage_tDBOutput_8);
							}
						}
					}
				}

				/**
				 * [tDBOutput_8 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String vehicle_id;

		public String getVehicle_id() {
			return this.vehicle_id;
		}

		public String mode;

		public String getMode() {
			return this.mode;
		}

		public String fuel_type;

		public String getFuel_type() {
			return this.fuel_type;
		}

		public String year_model;

		public String getYear_model() {
			return this.year_model;
		}

		public String operateur;

		public String getOperateur() {
			return this.operateur;
		}

		public String line_id;

		public String getLine_id() {
			return this.line_id;
		}

		public String capacity;

		public String getCapacity() {
			return this.capacity;
		}

		public String eco_label;

		public String getEco_label() {
			return this.eco_label;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.vehicle_id = readString(dis);

					this.mode = readString(dis);

					this.fuel_type = readString(dis);

					this.year_model = readString(dis);

					this.operateur = readString(dis);

					this.line_id = readString(dis);

					this.capacity = readString(dis);

					this.eco_label = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.vehicle_id = readString(dis);

					this.mode = readString(dis);

					this.fuel_type = readString(dis);

					this.year_model = readString(dis);

					this.operateur = readString(dis);

					this.line_id = readString(dis);

					this.capacity = readString(dis);

					this.eco_label = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.vehicle_id, dos);

				// String

				writeString(this.mode, dos);

				// String

				writeString(this.fuel_type, dos);

				// String

				writeString(this.year_model, dos);

				// String

				writeString(this.operateur, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.capacity, dos);

				// String

				writeString(this.eco_label, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.vehicle_id, dos);

				// String

				writeString(this.mode, dos);

				// String

				writeString(this.fuel_type, dos);

				// String

				writeString(this.year_model, dos);

				// String

				writeString(this.operateur, dos);

				// String

				writeString(this.line_id, dos);

				// String

				writeString(this.capacity, dos);

				// String

				writeString(this.eco_label, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("vehicle_id=" + vehicle_id);
			sb.append(",mode=" + mode);
			sb.append(",fuel_type=" + fuel_type);
			sb.append(",year_model=" + year_model);
			sb.append(",operateur=" + operateur);
			sb.append(",line_id=" + line_id);
			sb.append(",capacity=" + capacity);
			sb.append(",eco_label=" + eco_label);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

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

	public void tFileInputDelimited_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_9 begin ] start
				 */

				ok_Hash.put("tDBOutput_9", false);
				start_Hash.put("tDBOutput_9", System.currentTimeMillis());

				currentComponent = "tDBOutput_9";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tDBOutput_9 = 0;

				int nb_line_tDBOutput_9 = 0;
				int nb_line_update_tDBOutput_9 = 0;
				int nb_line_inserted_tDBOutput_9 = 0;
				int nb_line_deleted_tDBOutput_9 = 0;
				int nb_line_rejected_tDBOutput_9 = 0;

				int deletedCount_tDBOutput_9 = 0;
				int updatedCount_tDBOutput_9 = 0;
				int insertedCount_tDBOutput_9 = 0;
				int rowsToCommitCount_tDBOutput_9 = 0;
				int rejectedCount_tDBOutput_9 = 0;
				String dbschema_tDBOutput_9 = null;
				String tableName_tDBOutput_9 = null;
				boolean whetherReject_tDBOutput_9 = false;

				java.util.Calendar calendar_tDBOutput_9 = java.util.Calendar.getInstance();
				long year1_tDBOutput_9 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_9 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_9 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_9;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_9 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_9 = null;
				String dbUser_tDBOutput_9 = null;
				dbschema_tDBOutput_9 = "dbo";
				String driverClass_tDBOutput_9 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_9);
				String port_tDBOutput_9 = "1433";
				String dbname_tDBOutput_9 = "UrbanMobility";
				String url_tDBOutput_9 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_9)) {
					url_tDBOutput_9 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_9)) {
					url_tDBOutput_9 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_9 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_9 = "miming";

				final String decryptedPassword_tDBOutput_9 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:4uLMktS+q7BBag/ShdjRcRRZ+C38yQ1IrTOijvzw83qr5w==");

				String dbPwd_tDBOutput_9 = decryptedPassword_tDBOutput_9;
				conn_tDBOutput_9 = java.sql.DriverManager.getConnection(url_tDBOutput_9, dbUser_tDBOutput_9,
						dbPwd_tDBOutput_9);

				resourceMap.put("conn_tDBOutput_9", conn_tDBOutput_9);

				conn_tDBOutput_9.setAutoCommit(false);
				int commitEvery_tDBOutput_9 = 10000;
				int commitCounter_tDBOutput_9 = 0;

				int batchSize_tDBOutput_9 = 10000;
				int batchSizeCounter_tDBOutput_9 = 0;

				if (dbschema_tDBOutput_9 == null || dbschema_tDBOutput_9.trim().length() == 0) {
					tableName_tDBOutput_9 = "Stagingvehicules";
				} else {
					tableName_tDBOutput_9 = dbschema_tDBOutput_9 + "].[" + "Stagingvehicules";
				}
				int count_tDBOutput_9 = 0;

				boolean whetherExist_tDBOutput_9 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_9 = conn_tDBOutput_9.createStatement()) {
					try {
						isExistStmt_tDBOutput_9.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_9 + "]");
						whetherExist_tDBOutput_9 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_9_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_9 = false;
					}
				}
				if (!whetherExist_tDBOutput_9) {
					try (java.sql.Statement stmtCreate_tDBOutput_9 = conn_tDBOutput_9.createStatement()) {
						stmtCreate_tDBOutput_9.execute("CREATE TABLE [" + tableName_tDBOutput_9
								+ "]([vehicle_id] VARCHAR(20)  ,[mode] VARCHAR(20)  ,[fuel_type] VARCHAR(30)  ,[year_model] VARCHAR(10)  ,[operateur] VARCHAR(50)  ,[line_id] VARCHAR(20)  ,[capacity] VARCHAR(10)  ,[eco_label] VARCHAR(30)  )");
					}
				}
				String insert_tDBOutput_9 = "INSERT INTO [" + tableName_tDBOutput_9
						+ "] ([vehicle_id],[mode],[fuel_type],[year_model],[operateur],[line_id],[capacity],[eco_label]) VALUES (?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_9 = conn_tDBOutput_9.prepareStatement(insert_tDBOutput_9);
				resourceMap.put("pstmt_tDBOutput_9", pstmt_tDBOutput_9);

				/**
				 * [tDBOutput_9 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_9 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_9", false);
				start_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_9";

				int tos_count_tFileInputDelimited_9 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_9 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_9 = 0;
				int footer_tFileInputDelimited_9 = 0;
				int totalLinetFileInputDelimited_9 = 0;
				int limittFileInputDelimited_9 = -1;
				int lastLinetFileInputDelimited_9 = -1;

				char fieldSeparator_tFileInputDelimited_9[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_9 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_9[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_9 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_9 = /** Start field tFileInputDelimited_9:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/vehicules.csv"/**
																					 * End field
																					 * tFileInputDelimited_9:FILENAME
																					 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_9 = null;

				try {

					String[] rowtFileInputDelimited_9 = null;
					int currentLinetFileInputDelimited_9 = 0;
					int outputLinetFileInputDelimited_9 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_9 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_9 = 0;
							if (footer_value_tFileInputDelimited_9 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_9 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_9,
									fieldSeparator_tFileInputDelimited_9[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_9 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_9),
									fieldSeparator_tFileInputDelimited_9[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_9.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_9[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_9[0] != '\r'))
							csvReadertFileInputDelimited_9.setLineEnd("" + rowSeparator_tFileInputDelimited_9[0]);

						csvReadertFileInputDelimited_9.setQuoteChar('"');

						csvReadertFileInputDelimited_9.setEscapeChar(csvReadertFileInputDelimited_9.getQuoteChar());

						if (footer_tFileInputDelimited_9 > 0) {
							for (totalLinetFileInputDelimited_9 = 0; totalLinetFileInputDelimited_9 < 1; totalLinetFileInputDelimited_9++) {
								csvReadertFileInputDelimited_9.readNext();
							}
							csvReadertFileInputDelimited_9.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_9.readNext()) {

								rowtFileInputDelimited_9 = csvReadertFileInputDelimited_9.getValues();
								if (!(rowtFileInputDelimited_9.length == 1
										&& ("\015").equals(rowtFileInputDelimited_9[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_9++;

								}

							}
							int lastLineTemptFileInputDelimited_9 = totalLinetFileInputDelimited_9
									- footer_tFileInputDelimited_9 < 0 ? 0
											: totalLinetFileInputDelimited_9 - footer_tFileInputDelimited_9;
							if (lastLinetFileInputDelimited_9 > 0) {
								lastLinetFileInputDelimited_9 = lastLinetFileInputDelimited_9 < lastLineTemptFileInputDelimited_9
										? lastLinetFileInputDelimited_9
										: lastLineTemptFileInputDelimited_9;
							} else {
								lastLinetFileInputDelimited_9 = lastLineTemptFileInputDelimited_9;
							}

							csvReadertFileInputDelimited_9.close();
							if (filename_tFileInputDelimited_9 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_9 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_9,
										fieldSeparator_tFileInputDelimited_9[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_9 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_9),
										fieldSeparator_tFileInputDelimited_9[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_9.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_9[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_9[0] != '\r'))
								csvReadertFileInputDelimited_9.setLineEnd("" + rowSeparator_tFileInputDelimited_9[0]);

							csvReadertFileInputDelimited_9.setQuoteChar('"');

							csvReadertFileInputDelimited_9.setEscapeChar(csvReadertFileInputDelimited_9.getQuoteChar());

						}

						if (limittFileInputDelimited_9 != 0) {
							for (currentLinetFileInputDelimited_9 = 0; currentLinetFileInputDelimited_9 < 1; currentLinetFileInputDelimited_9++) {
								csvReadertFileInputDelimited_9.readNext();
							}
						}
						csvReadertFileInputDelimited_9.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_9 != 0 && csvReadertFileInputDelimited_9 != null
							&& csvReadertFileInputDelimited_9.readNext()) {
						rowstate_tFileInputDelimited_9.reset();

						rowtFileInputDelimited_9 = csvReadertFileInputDelimited_9.getValues();

						if (rowtFileInputDelimited_9.length == 1 && ("\015").equals(rowtFileInputDelimited_9[0])) {// empty
																													// line
																													// when
																													// row
																													// separator
																													// is
																													// '\n'
							continue;
						}

						currentLinetFileInputDelimited_9++;

						if (lastLinetFileInputDelimited_9 > -1
								&& currentLinetFileInputDelimited_9 > lastLinetFileInputDelimited_9) {
							break;
						}
						outputLinetFileInputDelimited_9++;
						if (limittFileInputDelimited_9 > 0
								&& outputLinetFileInputDelimited_9 > limittFileInputDelimited_9) {
							break;
						}

						row6 = null;

						boolean whetherReject_tFileInputDelimited_9 = false;
						row6 = new row6Struct();
						try {

							char fieldSeparator_tFileInputDelimited_9_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_9_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_9.length == 1 && ("\015").equals(rowtFileInputDelimited_9[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row6.vehicle_id = null;

								row6.mode = null;

								row6.fuel_type = null;

								row6.year_model = null;

								row6.operateur = null;

								row6.line_id = null;

								row6.capacity = null;

								row6.eco_label = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_9 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_9 = 0;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.vehicle_id = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.vehicle_id = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 1;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.mode = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.mode = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 2;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.fuel_type = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.fuel_type = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 3;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.year_model = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.year_model = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 4;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.operateur = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.operateur = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 5;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.line_id = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.line_id = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 6;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.capacity = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.capacity = null;

								}

								columnIndexWithD_tFileInputDelimited_9 = 7;

								if (columnIndexWithD_tFileInputDelimited_9 < rowtFileInputDelimited_9.length) {

									row6.eco_label = rowtFileInputDelimited_9[columnIndexWithD_tFileInputDelimited_9];

								} else {

									row6.eco_label = null;

								}

							}

							if (rowstate_tFileInputDelimited_9.getException() != null) {
								throw rowstate_tFileInputDelimited_9.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_9 = true;

							System.err.println(e.getMessage());
							row6 = null;

							globalMap.put("tFileInputDelimited_9_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_9 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_9 main ] start
						 */

						currentComponent = "tFileInputDelimited_9";

						tos_count_tFileInputDelimited_9++;

						/**
						 * [tFileInputDelimited_9 main ] stop
						 */

						/**
						 * [tFileInputDelimited_9 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_9";

						/**
						 * [tFileInputDelimited_9 process_data_begin ] stop
						 */
// Start of branch "row6"
						if (row6 != null) {

							/**
							 * [tDBOutput_9 main ] start
							 */

							currentComponent = "tDBOutput_9";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row6"

								);
							}

							whetherReject_tDBOutput_9 = false;
							if (row6.vehicle_id == null) {
								pstmt_tDBOutput_9.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(1, row6.vehicle_id);
							}

							if (row6.mode == null) {
								pstmt_tDBOutput_9.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(2, row6.mode);
							}

							if (row6.fuel_type == null) {
								pstmt_tDBOutput_9.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(3, row6.fuel_type);
							}

							if (row6.year_model == null) {
								pstmt_tDBOutput_9.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(4, row6.year_model);
							}

							if (row6.operateur == null) {
								pstmt_tDBOutput_9.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(5, row6.operateur);
							}

							if (row6.line_id == null) {
								pstmt_tDBOutput_9.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(6, row6.line_id);
							}

							if (row6.capacity == null) {
								pstmt_tDBOutput_9.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(7, row6.capacity);
							}

							if (row6.eco_label == null) {
								pstmt_tDBOutput_9.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_9.setString(8, row6.eco_label);
							}

							pstmt_tDBOutput_9.addBatch();
							nb_line_tDBOutput_9++;

							batchSizeCounter_tDBOutput_9++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_9 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_9)
										throws Exception {
									try {

										for (int countEach_tDBOutput_9 : pstmt_tDBOutput_9.executeBatch()) {
											if (countEach_tDBOutput_9 == -2 || countEach_tDBOutput_9 == -3) {
												break;
											}
											counter += countEach_tDBOutput_9;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_9_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_9 = 0;
										for (int countEach_tDBOutput_9 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_9)
										throws Exception {
									try {

										for (int countEach_tDBOutput_9 : pstmt_tDBOutput_9.executeBatch()) {
											if (countEach_tDBOutput_9 == -2 || countEach_tDBOutput_9 == -3) {
												break;
											}
											counter += countEach_tDBOutput_9;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_9_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_9 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_9 > 0)
									&& (batchSize_tDBOutput_9 <= batchSizeCounter_tDBOutput_9)) {

								insertedCount_tDBOutput_9 = new LimitBytesHelper_tDBOutput_9()
										.limitBytePart1(insertedCount_tDBOutput_9, pstmt_tDBOutput_9);
								rowsToCommitCount_tDBOutput_9 = insertedCount_tDBOutput_9;

								batchSizeCounter_tDBOutput_9 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_9++;
							if (commitEvery_tDBOutput_9 <= commitCounter_tDBOutput_9) {
								if ((batchSize_tDBOutput_9 > 0) && (batchSizeCounter_tDBOutput_9 > 0)) {

									insertedCount_tDBOutput_9 = new LimitBytesHelper_tDBOutput_9()
											.limitBytePart1(insertedCount_tDBOutput_9, pstmt_tDBOutput_9);

									batchSizeCounter_tDBOutput_9 = 0;
								}
								if (rowsToCommitCount_tDBOutput_9 != 0) {

								}
								conn_tDBOutput_9.commit();
								if (rowsToCommitCount_tDBOutput_9 != 0) {

									rowsToCommitCount_tDBOutput_9 = 0;
								}
								commitCounter_tDBOutput_9 = 0;
							}

							tos_count_tDBOutput_9++;

							/**
							 * [tDBOutput_9 main ] stop
							 */

							/**
							 * [tDBOutput_9 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_9";

							/**
							 * [tDBOutput_9 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_9 process_data_end ] start
							 */

							currentComponent = "tDBOutput_9";

							/**
							 * [tDBOutput_9 process_data_end ] stop
							 */

						} // End of branch "row6"

						/**
						 * [tFileInputDelimited_9 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_9";

						/**
						 * [tFileInputDelimited_9 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_9 end ] start
						 */

						currentComponent = "tFileInputDelimited_9";

						nb_line_tFileInputDelimited_9++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_9 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_9 != null) {
							csvReadertFileInputDelimited_9.close();
						}
					}
					if (csvReadertFileInputDelimited_9 != null) {
						globalMap.put("tFileInputDelimited_9_NB_LINE", nb_line_tFileInputDelimited_9);
					}

				}

				ok_Hash.put("tFileInputDelimited_9", true);
				end_Hash.put("tFileInputDelimited_9", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_9 end ] stop
				 */

				/**
				 * [tDBOutput_9 end ] start
				 */

				currentComponent = "tDBOutput_9";

				try {
					int countSum_tDBOutput_9 = 0;
					if (pstmt_tDBOutput_9 != null && batchSizeCounter_tDBOutput_9 > 0) {

						for (int countEach_tDBOutput_9 : pstmt_tDBOutput_9.executeBatch()) {
							if (countEach_tDBOutput_9 == -2 || countEach_tDBOutput_9 == -3) {
								break;
							}
							countSum_tDBOutput_9 += countEach_tDBOutput_9;
						}
						rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;

					}

					insertedCount_tDBOutput_9 += countSum_tDBOutput_9;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_9_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_9 = 0;
					for (int countEach_tDBOutput_9 : e.getUpdateCounts()) {
						countSum_tDBOutput_9 += (countEach_tDBOutput_9 < 0 ? 0 : countEach_tDBOutput_9);
					}
					rowsToCommitCount_tDBOutput_9 += countSum_tDBOutput_9;

					insertedCount_tDBOutput_9 += countSum_tDBOutput_9;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_9 != null) {

					pstmt_tDBOutput_9.close();
					resourceMap.remove("pstmt_tDBOutput_9");

				}
				resourceMap.put("statementClosed_tDBOutput_9", true);
				if (rowsToCommitCount_tDBOutput_9 != 0) {

				}
				conn_tDBOutput_9.commit();
				if (rowsToCommitCount_tDBOutput_9 != 0) {

					rowsToCommitCount_tDBOutput_9 = 0;
				}
				commitCounter_tDBOutput_9 = 0;
				conn_tDBOutput_9.close();
				resourceMap.put("finish_tDBOutput_9", true);

				nb_line_deleted_tDBOutput_9 = nb_line_deleted_tDBOutput_9 + deletedCount_tDBOutput_9;
				nb_line_update_tDBOutput_9 = nb_line_update_tDBOutput_9 + updatedCount_tDBOutput_9;
				nb_line_inserted_tDBOutput_9 = nb_line_inserted_tDBOutput_9 + insertedCount_tDBOutput_9;
				nb_line_rejected_tDBOutput_9 = nb_line_rejected_tDBOutput_9 + rejectedCount_tDBOutput_9;

				globalMap.put("tDBOutput_9_NB_LINE", nb_line_tDBOutput_9);
				globalMap.put("tDBOutput_9_NB_LINE_UPDATED", nb_line_update_tDBOutput_9);
				globalMap.put("tDBOutput_9_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_9);
				globalMap.put("tDBOutput_9_NB_LINE_DELETED", nb_line_deleted_tDBOutput_9);
				globalMap.put("tDBOutput_9_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_9);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tDBOutput_9", true);
				end_Hash.put("tDBOutput_9", System.currentTimeMillis());

				/**
				 * [tDBOutput_9 end ] stop
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
				 * [tFileInputDelimited_9 finally ] start
				 */

				currentComponent = "tFileInputDelimited_9";

				/**
				 * [tFileInputDelimited_9 finally ] stop
				 */

				/**
				 * [tDBOutput_9 finally ] start
				 */

				currentComponent = "tDBOutput_9";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_9") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_9 = null;
						if ((pstmtToClose_tDBOutput_9 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_9")) != null) {
							pstmtToClose_tDBOutput_9.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_9") == null) {
						java.sql.Connection ctn_tDBOutput_9 = null;
						if ((ctn_tDBOutput_9 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_9")) != null) {
							try {
								ctn_tDBOutput_9.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_9) {
								String errorMessage_tDBOutput_9 = "failed to close the connection in tDBOutput_9 :"
										+ sqlEx_tDBOutput_9.getMessage();
								System.err.println(errorMessage_tDBOutput_9);
							}
						}
					}
				}

				/**
				 * [tDBOutput_9 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String zone_id;

		public String getZone_id() {
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

		public String lat_centre;

		public String getLat_centre() {
			return this.lat_centre;
		}

		public String lon_centre;

		public String getLon_centre() {
			return this.lon_centre;
		}

		public String surface_km2;

		public String getSurface_km2() {
			return this.surface_km2;
		}

		public String population_estimee;

		public String getPopulation_estimee() {
			return this.population_estimee;
		}

		public String code_insee_commune;

		public String getCode_insee_commune() {
			return this.code_insee_commune;
		}

		public String note_admin;

		public String getNote_admin() {
			return this.note_admin;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone_nom = readString(dis);

					this.ville = readString(dis);

					this.region = readString(dis);

					this.pays = readString(dis);

					this.lat_centre = readString(dis);

					this.lon_centre = readString(dis);

					this.surface_km2 = readString(dis);

					this.population_estimee = readString(dis);

					this.code_insee_commune = readString(dis);

					this.note_admin = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone_nom = readString(dis);

					this.ville = readString(dis);

					this.region = readString(dis);

					this.pays = readString(dis);

					this.lat_centre = readString(dis);

					this.lon_centre = readString(dis);

					this.surface_km2 = readString(dis);

					this.population_estimee = readString(dis);

					this.code_insee_commune = readString(dis);

					this.note_admin = readString(dis);

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

				writeString(this.zone_nom, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.pays, dos);

				// String

				writeString(this.lat_centre, dos);

				// String

				writeString(this.lon_centre, dos);

				// String

				writeString(this.surface_km2, dos);

				// String

				writeString(this.population_estimee, dos);

				// String

				writeString(this.code_insee_commune, dos);

				// String

				writeString(this.note_admin, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone_nom, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.pays, dos);

				// String

				writeString(this.lat_centre, dos);

				// String

				writeString(this.lon_centre, dos);

				// String

				writeString(this.surface_km2, dos);

				// String

				writeString(this.population_estimee, dos);

				// String

				writeString(this.code_insee_commune, dos);

				// String

				writeString(this.note_admin, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone_nom=" + zone_nom);
			sb.append(",ville=" + ville);
			sb.append(",region=" + region);
			sb.append(",pays=" + pays);
			sb.append(",lat_centre=" + lat_centre);
			sb.append(",lon_centre=" + lon_centre);
			sb.append(",surface_km2=" + surface_km2);
			sb.append(",population_estimee=" + population_estimee);
			sb.append(",code_insee_commune=" + code_insee_commune);
			sb.append(",note_admin=" + note_admin);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

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

	public void tFileInputDelimited_10Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_10 begin ] start
				 */

				ok_Hash.put("tDBOutput_10", false);
				start_Hash.put("tDBOutput_10", System.currentTimeMillis());

				currentComponent = "tDBOutput_10";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tDBOutput_10 = 0;

				int nb_line_tDBOutput_10 = 0;
				int nb_line_update_tDBOutput_10 = 0;
				int nb_line_inserted_tDBOutput_10 = 0;
				int nb_line_deleted_tDBOutput_10 = 0;
				int nb_line_rejected_tDBOutput_10 = 0;

				int deletedCount_tDBOutput_10 = 0;
				int updatedCount_tDBOutput_10 = 0;
				int insertedCount_tDBOutput_10 = 0;
				int rowsToCommitCount_tDBOutput_10 = 0;
				int rejectedCount_tDBOutput_10 = 0;
				String dbschema_tDBOutput_10 = null;
				String tableName_tDBOutput_10 = null;
				boolean whetherReject_tDBOutput_10 = false;

				java.util.Calendar calendar_tDBOutput_10 = java.util.Calendar.getInstance();
				long year1_tDBOutput_10 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_10 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_10 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_10;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_10 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_10 = null;
				String dbUser_tDBOutput_10 = null;
				dbschema_tDBOutput_10 = "dbo";
				String driverClass_tDBOutput_10 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_10);
				String port_tDBOutput_10 = "1433";
				String dbname_tDBOutput_10 = "UrbanMobility";
				String url_tDBOutput_10 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_10)) {
					url_tDBOutput_10 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_10)) {
					url_tDBOutput_10 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_10 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_10 = "miming";

				final String decryptedPassword_tDBOutput_10 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:yJOdvvBbIf7XC+q9taAHm0+/9/nQyJefxtLohxIE1Gy7Fw==");

				String dbPwd_tDBOutput_10 = decryptedPassword_tDBOutput_10;
				conn_tDBOutput_10 = java.sql.DriverManager.getConnection(url_tDBOutput_10, dbUser_tDBOutput_10,
						dbPwd_tDBOutput_10);

				resourceMap.put("conn_tDBOutput_10", conn_tDBOutput_10);

				conn_tDBOutput_10.setAutoCommit(false);
				int commitEvery_tDBOutput_10 = 10000;
				int commitCounter_tDBOutput_10 = 0;

				int batchSize_tDBOutput_10 = 10000;
				int batchSizeCounter_tDBOutput_10 = 0;

				if (dbschema_tDBOutput_10 == null || dbschema_tDBOutput_10.trim().length() == 0) {
					tableName_tDBOutput_10 = "Stagingzone";
				} else {
					tableName_tDBOutput_10 = dbschema_tDBOutput_10 + "].[" + "Stagingzone";
				}
				int count_tDBOutput_10 = 0;

				int rsTruncCountNumber_tDBOutput_10 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_10 = conn_tDBOutput_10.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_10 = stmtTruncCount_tDBOutput_10
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_10 + "]")) {
						if (rsTruncCount_tDBOutput_10.next()) {
							rsTruncCountNumber_tDBOutput_10 = rsTruncCount_tDBOutput_10.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_10 = conn_tDBOutput_10.createStatement()) {
					stmtTrunc_tDBOutput_10.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_10 + "]");
					deletedCount_tDBOutput_10 += rsTruncCountNumber_tDBOutput_10;
				}
				String insert_tDBOutput_10 = "INSERT INTO [" + tableName_tDBOutput_10
						+ "] ([zone_id],[zone_nom],[ville],[region],[pays],[lat_centre],[lon_centre],[surface_km2],[population_estimee],[code_insee_commune],[note_admin]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_10 = conn_tDBOutput_10.prepareStatement(insert_tDBOutput_10);
				resourceMap.put("pstmt_tDBOutput_10", pstmt_tDBOutput_10);

				/**
				 * [tDBOutput_10 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_10 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_10", false);
				start_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_10";

				int tos_count_tFileInputDelimited_10 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_10 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_10 = 0;
				int footer_tFileInputDelimited_10 = 0;
				int totalLinetFileInputDelimited_10 = 0;
				int limittFileInputDelimited_10 = -1;
				int lastLinetFileInputDelimited_10 = -1;

				char fieldSeparator_tFileInputDelimited_10[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_10 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_10[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_10 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_10 = /** Start field tFileInputDelimited_10:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/zones.csv"/**
																				 * End field
																				 * tFileInputDelimited_10:FILENAME
																				 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_10 = null;

				try {

					String[] rowtFileInputDelimited_10 = null;
					int currentLinetFileInputDelimited_10 = 0;
					int outputLinetFileInputDelimited_10 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_10 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_10 = 0;
							if (footer_value_tFileInputDelimited_10 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_10 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_10,
									fieldSeparator_tFileInputDelimited_10[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_10 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_10),
									fieldSeparator_tFileInputDelimited_10[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_10.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_10[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_10[0] != '\r'))
							csvReadertFileInputDelimited_10.setLineEnd("" + rowSeparator_tFileInputDelimited_10[0]);

						csvReadertFileInputDelimited_10.setQuoteChar('"');

						csvReadertFileInputDelimited_10.setEscapeChar(csvReadertFileInputDelimited_10.getQuoteChar());

						if (footer_tFileInputDelimited_10 > 0) {
							for (totalLinetFileInputDelimited_10 = 0; totalLinetFileInputDelimited_10 < 1; totalLinetFileInputDelimited_10++) {
								csvReadertFileInputDelimited_10.readNext();
							}
							csvReadertFileInputDelimited_10.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_10.readNext()) {

								rowtFileInputDelimited_10 = csvReadertFileInputDelimited_10.getValues();
								if (!(rowtFileInputDelimited_10.length == 1
										&& ("\015").equals(rowtFileInputDelimited_10[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_10++;

								}

							}
							int lastLineTemptFileInputDelimited_10 = totalLinetFileInputDelimited_10
									- footer_tFileInputDelimited_10 < 0 ? 0
											: totalLinetFileInputDelimited_10 - footer_tFileInputDelimited_10;
							if (lastLinetFileInputDelimited_10 > 0) {
								lastLinetFileInputDelimited_10 = lastLinetFileInputDelimited_10 < lastLineTemptFileInputDelimited_10
										? lastLinetFileInputDelimited_10
										: lastLineTemptFileInputDelimited_10;
							} else {
								lastLinetFileInputDelimited_10 = lastLineTemptFileInputDelimited_10;
							}

							csvReadertFileInputDelimited_10.close();
							if (filename_tFileInputDelimited_10 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_10 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_10,
										fieldSeparator_tFileInputDelimited_10[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_10 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_10),
										fieldSeparator_tFileInputDelimited_10[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_10.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_10[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_10[0] != '\r'))
								csvReadertFileInputDelimited_10.setLineEnd("" + rowSeparator_tFileInputDelimited_10[0]);

							csvReadertFileInputDelimited_10.setQuoteChar('"');

							csvReadertFileInputDelimited_10
									.setEscapeChar(csvReadertFileInputDelimited_10.getQuoteChar());

						}

						if (limittFileInputDelimited_10 != 0) {
							for (currentLinetFileInputDelimited_10 = 0; currentLinetFileInputDelimited_10 < 1; currentLinetFileInputDelimited_10++) {
								csvReadertFileInputDelimited_10.readNext();
							}
						}
						csvReadertFileInputDelimited_10.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_10 != 0 && csvReadertFileInputDelimited_10 != null
							&& csvReadertFileInputDelimited_10.readNext()) {
						rowstate_tFileInputDelimited_10.reset();

						rowtFileInputDelimited_10 = csvReadertFileInputDelimited_10.getValues();

						if (rowtFileInputDelimited_10.length == 1 && ("\015").equals(rowtFileInputDelimited_10[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'
							continue;
						}

						currentLinetFileInputDelimited_10++;

						if (lastLinetFileInputDelimited_10 > -1
								&& currentLinetFileInputDelimited_10 > lastLinetFileInputDelimited_10) {
							break;
						}
						outputLinetFileInputDelimited_10++;
						if (limittFileInputDelimited_10 > 0
								&& outputLinetFileInputDelimited_10 > limittFileInputDelimited_10) {
							break;
						}

						row4 = null;

						boolean whetherReject_tFileInputDelimited_10 = false;
						row4 = new row4Struct();
						try {

							char fieldSeparator_tFileInputDelimited_10_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_10_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_10.length == 1
									&& ("\015").equals(rowtFileInputDelimited_10[0])) {// empty line when row separator
																						// is '\n'

								row4.zone_id = null;

								row4.zone_nom = null;

								row4.ville = null;

								row4.region = null;

								row4.pays = null;

								row4.lat_centre = null;

								row4.lon_centre = null;

								row4.surface_km2 = null;

								row4.population_estimee = null;

								row4.code_insee_commune = null;

								row4.note_admin = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_10 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_10 = 0;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.zone_id = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.zone_id = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 1;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.zone_nom = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.zone_nom = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 2;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.ville = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.ville = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 3;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.region = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.region = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 4;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.pays = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.pays = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 5;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.lat_centre = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.lat_centre = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 6;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.lon_centre = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.lon_centre = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 7;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.surface_km2 = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.surface_km2 = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 8;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.population_estimee = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.population_estimee = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 9;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.code_insee_commune = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.code_insee_commune = null;

								}

								columnIndexWithD_tFileInputDelimited_10 = 10;

								if (columnIndexWithD_tFileInputDelimited_10 < rowtFileInputDelimited_10.length) {

									row4.note_admin = rowtFileInputDelimited_10[columnIndexWithD_tFileInputDelimited_10];

								} else {

									row4.note_admin = null;

								}

							}

							if (rowstate_tFileInputDelimited_10.getException() != null) {
								throw rowstate_tFileInputDelimited_10.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_10 = true;

							System.err.println(e.getMessage());
							row4 = null;

							globalMap.put("tFileInputDelimited_10_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_10 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_10 main ] start
						 */

						currentComponent = "tFileInputDelimited_10";

						tos_count_tFileInputDelimited_10++;

						/**
						 * [tFileInputDelimited_10 main ] stop
						 */

						/**
						 * [tFileInputDelimited_10 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_10";

						/**
						 * [tFileInputDelimited_10 process_data_begin ] stop
						 */
// Start of branch "row4"
						if (row4 != null) {

							/**
							 * [tDBOutput_10 main ] start
							 */

							currentComponent = "tDBOutput_10";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row4"

								);
							}

							whetherReject_tDBOutput_10 = false;
							if (row4.zone_id == null) {
								pstmt_tDBOutput_10.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(1, row4.zone_id);
							}

							if (row4.zone_nom == null) {
								pstmt_tDBOutput_10.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(2, row4.zone_nom);
							}

							if (row4.ville == null) {
								pstmt_tDBOutput_10.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(3, row4.ville);
							}

							if (row4.region == null) {
								pstmt_tDBOutput_10.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(4, row4.region);
							}

							if (row4.pays == null) {
								pstmt_tDBOutput_10.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(5, row4.pays);
							}

							if (row4.lat_centre == null) {
								pstmt_tDBOutput_10.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(6, row4.lat_centre);
							}

							if (row4.lon_centre == null) {
								pstmt_tDBOutput_10.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(7, row4.lon_centre);
							}

							if (row4.surface_km2 == null) {
								pstmt_tDBOutput_10.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(8, row4.surface_km2);
							}

							if (row4.population_estimee == null) {
								pstmt_tDBOutput_10.setNull(9, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(9, row4.population_estimee);
							}

							if (row4.code_insee_commune == null) {
								pstmt_tDBOutput_10.setNull(10, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(10, row4.code_insee_commune);
							}

							if (row4.note_admin == null) {
								pstmt_tDBOutput_10.setNull(11, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_10.setString(11, row4.note_admin);
							}

							pstmt_tDBOutput_10.addBatch();
							nb_line_tDBOutput_10++;

							batchSizeCounter_tDBOutput_10++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_10 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_10)
										throws Exception {
									try {

										for (int countEach_tDBOutput_10 : pstmt_tDBOutput_10.executeBatch()) {
											if (countEach_tDBOutput_10 == -2 || countEach_tDBOutput_10 == -3) {
												break;
											}
											counter += countEach_tDBOutput_10;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_10_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_10 = 0;
										for (int countEach_tDBOutput_10 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_10)
										throws Exception {
									try {

										for (int countEach_tDBOutput_10 : pstmt_tDBOutput_10.executeBatch()) {
											if (countEach_tDBOutput_10 == -2 || countEach_tDBOutput_10 == -3) {
												break;
											}
											counter += countEach_tDBOutput_10;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_10_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_10 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_10 > 0)
									&& (batchSize_tDBOutput_10 <= batchSizeCounter_tDBOutput_10)) {

								insertedCount_tDBOutput_10 = new LimitBytesHelper_tDBOutput_10()
										.limitBytePart1(insertedCount_tDBOutput_10, pstmt_tDBOutput_10);
								rowsToCommitCount_tDBOutput_10 = insertedCount_tDBOutput_10;

								batchSizeCounter_tDBOutput_10 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_10++;
							if (commitEvery_tDBOutput_10 <= commitCounter_tDBOutput_10) {
								if ((batchSize_tDBOutput_10 > 0) && (batchSizeCounter_tDBOutput_10 > 0)) {

									insertedCount_tDBOutput_10 = new LimitBytesHelper_tDBOutput_10()
											.limitBytePart1(insertedCount_tDBOutput_10, pstmt_tDBOutput_10);

									batchSizeCounter_tDBOutput_10 = 0;
								}
								if (rowsToCommitCount_tDBOutput_10 != 0) {

								}
								conn_tDBOutput_10.commit();
								if (rowsToCommitCount_tDBOutput_10 != 0) {

									rowsToCommitCount_tDBOutput_10 = 0;
								}
								commitCounter_tDBOutput_10 = 0;
							}

							tos_count_tDBOutput_10++;

							/**
							 * [tDBOutput_10 main ] stop
							 */

							/**
							 * [tDBOutput_10 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_10";

							/**
							 * [tDBOutput_10 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_10 process_data_end ] start
							 */

							currentComponent = "tDBOutput_10";

							/**
							 * [tDBOutput_10 process_data_end ] stop
							 */

						} // End of branch "row4"

						/**
						 * [tFileInputDelimited_10 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_10";

						/**
						 * [tFileInputDelimited_10 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_10 end ] start
						 */

						currentComponent = "tFileInputDelimited_10";

						nb_line_tFileInputDelimited_10++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_10 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_10 != null) {
							csvReadertFileInputDelimited_10.close();
						}
					}
					if (csvReadertFileInputDelimited_10 != null) {
						globalMap.put("tFileInputDelimited_10_NB_LINE", nb_line_tFileInputDelimited_10);
					}

				}

				ok_Hash.put("tFileInputDelimited_10", true);
				end_Hash.put("tFileInputDelimited_10", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_10 end ] stop
				 */

				/**
				 * [tDBOutput_10 end ] start
				 */

				currentComponent = "tDBOutput_10";

				try {
					int countSum_tDBOutput_10 = 0;
					if (pstmt_tDBOutput_10 != null && batchSizeCounter_tDBOutput_10 > 0) {

						for (int countEach_tDBOutput_10 : pstmt_tDBOutput_10.executeBatch()) {
							if (countEach_tDBOutput_10 == -2 || countEach_tDBOutput_10 == -3) {
								break;
							}
							countSum_tDBOutput_10 += countEach_tDBOutput_10;
						}
						rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;

					}

					insertedCount_tDBOutput_10 += countSum_tDBOutput_10;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_10_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_10 = 0;
					for (int countEach_tDBOutput_10 : e.getUpdateCounts()) {
						countSum_tDBOutput_10 += (countEach_tDBOutput_10 < 0 ? 0 : countEach_tDBOutput_10);
					}
					rowsToCommitCount_tDBOutput_10 += countSum_tDBOutput_10;

					insertedCount_tDBOutput_10 += countSum_tDBOutput_10;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_10 != null) {

					pstmt_tDBOutput_10.close();
					resourceMap.remove("pstmt_tDBOutput_10");

				}
				resourceMap.put("statementClosed_tDBOutput_10", true);
				if (rowsToCommitCount_tDBOutput_10 != 0) {

				}
				conn_tDBOutput_10.commit();
				if (rowsToCommitCount_tDBOutput_10 != 0) {

					rowsToCommitCount_tDBOutput_10 = 0;
				}
				commitCounter_tDBOutput_10 = 0;
				conn_tDBOutput_10.close();
				resourceMap.put("finish_tDBOutput_10", true);

				nb_line_deleted_tDBOutput_10 = nb_line_deleted_tDBOutput_10 + deletedCount_tDBOutput_10;
				nb_line_update_tDBOutput_10 = nb_line_update_tDBOutput_10 + updatedCount_tDBOutput_10;
				nb_line_inserted_tDBOutput_10 = nb_line_inserted_tDBOutput_10 + insertedCount_tDBOutput_10;
				nb_line_rejected_tDBOutput_10 = nb_line_rejected_tDBOutput_10 + rejectedCount_tDBOutput_10;

				globalMap.put("tDBOutput_10_NB_LINE", nb_line_tDBOutput_10);
				globalMap.put("tDBOutput_10_NB_LINE_UPDATED", nb_line_update_tDBOutput_10);
				globalMap.put("tDBOutput_10_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_10);
				globalMap.put("tDBOutput_10_NB_LINE_DELETED", nb_line_deleted_tDBOutput_10);
				globalMap.put("tDBOutput_10_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_10);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tDBOutput_10", true);
				end_Hash.put("tDBOutput_10", System.currentTimeMillis());

				/**
				 * [tDBOutput_10 end ] stop
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
				 * [tFileInputDelimited_10 finally ] start
				 */

				currentComponent = "tFileInputDelimited_10";

				/**
				 * [tFileInputDelimited_10 finally ] stop
				 */

				/**
				 * [tDBOutput_10 finally ] start
				 */

				currentComponent = "tDBOutput_10";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_10") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_10 = null;
						if ((pstmtToClose_tDBOutput_10 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_10")) != null) {
							pstmtToClose_tDBOutput_10.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_10") == null) {
						java.sql.Connection ctn_tDBOutput_10 = null;
						if ((ctn_tDBOutput_10 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_10")) != null) {
							try {
								ctn_tDBOutput_10.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_10) {
								String errorMessage_tDBOutput_10 = "failed to close the connection in tDBOutput_10 :"
										+ sqlEx_tDBOutput_10.getMessage();
								System.err.println(errorMessage_tDBOutput_10);
							}
						}
					}
				}

				/**
				 * [tDBOutput_10 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", 1);
	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[0];

		public String zone_id;

		public String getZone_id() {
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

		public String lat_centre;

		public String getLat_centre() {
			return this.lat_centre;
		}

		public String lon_centre;

		public String getLon_centre() {
			return this.lon_centre;
		}

		public String surface_km2;

		public String getSurface_km2() {
			return this.surface_km2;
		}

		public String population_estimee;

		public String getPopulation_estimee() {
			return this.population_estimee;
		}

		public String code_insee_commune;

		public String getCode_insee_commune() {
			return this.code_insee_commune;
		}

		public String note_admin;

		public String getNote_admin() {
			return this.note_admin;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadarretstostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadarretstostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadarretstostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadarretstostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone_nom = readString(dis);

					this.ville = readString(dis);

					this.region = readString(dis);

					this.pays = readString(dis);

					this.lat_centre = readString(dis);

					this.lon_centre = readString(dis);

					this.surface_km2 = readString(dis);

					this.population_estimee = readString(dis);

					this.code_insee_commune = readString(dis);

					this.note_admin = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadarretstostaging) {

				try {

					int length = 0;

					this.zone_id = readString(dis);

					this.zone_nom = readString(dis);

					this.ville = readString(dis);

					this.region = readString(dis);

					this.pays = readString(dis);

					this.lat_centre = readString(dis);

					this.lon_centre = readString(dis);

					this.surface_km2 = readString(dis);

					this.population_estimee = readString(dis);

					this.code_insee_commune = readString(dis);

					this.note_admin = readString(dis);

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

				writeString(this.zone_nom, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.pays, dos);

				// String

				writeString(this.lat_centre, dos);

				// String

				writeString(this.lon_centre, dos);

				// String

				writeString(this.surface_km2, dos);

				// String

				writeString(this.population_estimee, dos);

				// String

				writeString(this.code_insee_commune, dos);

				// String

				writeString(this.note_admin, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.zone_nom, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.region, dos);

				// String

				writeString(this.pays, dos);

				// String

				writeString(this.lat_centre, dos);

				// String

				writeString(this.lon_centre, dos);

				// String

				writeString(this.surface_km2, dos);

				// String

				writeString(this.population_estimee, dos);

				// String

				writeString(this.code_insee_commune, dos);

				// String

				writeString(this.note_admin, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("zone_id=" + zone_id);
			sb.append(",zone_nom=" + zone_nom);
			sb.append(",ville=" + ville);
			sb.append(",region=" + region);
			sb.append(",pays=" + pays);
			sb.append(",lat_centre=" + lat_centre);
			sb.append(",lon_centre=" + lon_centre);
			sb.append(",surface_km2=" + surface_km2);
			sb.append(",population_estimee=" + population_estimee);
			sb.append(",code_insee_commune=" + code_insee_commune);
			sb.append(",note_admin=" + note_admin);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

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

	public void tFileInputDelimited_11Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", 0);

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

				row7Struct row7 = new row7Struct();

				/**
				 * [tDBOutput_11 begin ] start
				 */

				ok_Hash.put("tDBOutput_11", false);
				start_Hash.put("tDBOutput_11", System.currentTimeMillis());

				currentComponent = "tDBOutput_11";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
				}

				int tos_count_tDBOutput_11 = 0;

				int nb_line_tDBOutput_11 = 0;
				int nb_line_update_tDBOutput_11 = 0;
				int nb_line_inserted_tDBOutput_11 = 0;
				int nb_line_deleted_tDBOutput_11 = 0;
				int nb_line_rejected_tDBOutput_11 = 0;

				int deletedCount_tDBOutput_11 = 0;
				int updatedCount_tDBOutput_11 = 0;
				int insertedCount_tDBOutput_11 = 0;
				int rowsToCommitCount_tDBOutput_11 = 0;
				int rejectedCount_tDBOutput_11 = 0;
				String dbschema_tDBOutput_11 = null;
				String tableName_tDBOutput_11 = null;
				boolean whetherReject_tDBOutput_11 = false;

				java.util.Calendar calendar_tDBOutput_11 = java.util.Calendar.getInstance();
				long year1_tDBOutput_11 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_11 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_11 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_11;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_11 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_11 = null;
				String dbUser_tDBOutput_11 = null;
				dbschema_tDBOutput_11 = "dbo";
				String driverClass_tDBOutput_11 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_11);
				String port_tDBOutput_11 = "1433";
				String dbname_tDBOutput_11 = "UrbanMobility";
				String url_tDBOutput_11 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_11)) {
					url_tDBOutput_11 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_11)) {
					url_tDBOutput_11 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_11 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_11 = "miming";

				final String decryptedPassword_tDBOutput_11 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:dP9mDlvYIS7hGbG3VuCFsB42MYnaTVrOUfvgryv9jGpPbA==");

				String dbPwd_tDBOutput_11 = decryptedPassword_tDBOutput_11;
				conn_tDBOutput_11 = java.sql.DriverManager.getConnection(url_tDBOutput_11, dbUser_tDBOutput_11,
						dbPwd_tDBOutput_11);

				resourceMap.put("conn_tDBOutput_11", conn_tDBOutput_11);

				conn_tDBOutput_11.setAutoCommit(false);
				int commitEvery_tDBOutput_11 = 10000;
				int commitCounter_tDBOutput_11 = 0;

				int batchSize_tDBOutput_11 = 10000;
				int batchSizeCounter_tDBOutput_11 = 0;

				if (dbschema_tDBOutput_11 == null || dbschema_tDBOutput_11.trim().length() == 0) {
					tableName_tDBOutput_11 = "Stagingzones_latin1";
				} else {
					tableName_tDBOutput_11 = dbschema_tDBOutput_11 + "].[" + "Stagingzones_latin1";
				}
				int count_tDBOutput_11 = 0;

				int rsTruncCountNumber_tDBOutput_11 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_11 = conn_tDBOutput_11.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_11 = stmtTruncCount_tDBOutput_11
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_11 + "]")) {
						if (rsTruncCount_tDBOutput_11.next()) {
							rsTruncCountNumber_tDBOutput_11 = rsTruncCount_tDBOutput_11.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_11 = conn_tDBOutput_11.createStatement()) {
					stmtTrunc_tDBOutput_11.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_11 + "]");
					deletedCount_tDBOutput_11 += rsTruncCountNumber_tDBOutput_11;
				}
				String insert_tDBOutput_11 = "INSERT INTO [" + tableName_tDBOutput_11
						+ "] ([zone_id],[zone_nom],[ville],[region],[pays],[lat_centre],[lon_centre],[surface_km2],[population_estimee],[code_insee_commune],[note_admin]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_11 = conn_tDBOutput_11.prepareStatement(insert_tDBOutput_11);
				resourceMap.put("pstmt_tDBOutput_11", pstmt_tDBOutput_11);

				/**
				 * [tDBOutput_11 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_11 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_11", false);
				start_Hash.put("tFileInputDelimited_11", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_11";

				int tos_count_tFileInputDelimited_11 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_11 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_11 = 0;
				int footer_tFileInputDelimited_11 = 0;
				int totalLinetFileInputDelimited_11 = 0;
				int limittFileInputDelimited_11 = -1;
				int lastLinetFileInputDelimited_11 = -1;

				char fieldSeparator_tFileInputDelimited_11[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_11 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_11[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_11 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_11 = /** Start field tFileInputDelimited_11:FILENAME */
						"C:/OneDrive_2026-01-21/Urban Mobility/data/zones_latin1.csv"/**
																						 * End field
																						 * tFileInputDelimited_11:FILENAME
																						 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_11 = null;

				try {

					String[] rowtFileInputDelimited_11 = null;
					int currentLinetFileInputDelimited_11 = 0;
					int outputLinetFileInputDelimited_11 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_11 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_11 = 0;
							if (footer_value_tFileInputDelimited_11 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_11 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_11,
									fieldSeparator_tFileInputDelimited_11[0], "ISO-8859-15");
						} else {
							csvReadertFileInputDelimited_11 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_11),
									fieldSeparator_tFileInputDelimited_11[0], "ISO-8859-15");
						}

						csvReadertFileInputDelimited_11.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_11[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_11[0] != '\r'))
							csvReadertFileInputDelimited_11.setLineEnd("" + rowSeparator_tFileInputDelimited_11[0]);

						csvReadertFileInputDelimited_11.setQuoteChar('"');

						csvReadertFileInputDelimited_11.setEscapeChar(csvReadertFileInputDelimited_11.getQuoteChar());

						if (footer_tFileInputDelimited_11 > 0) {
							for (totalLinetFileInputDelimited_11 = 0; totalLinetFileInputDelimited_11 < 1; totalLinetFileInputDelimited_11++) {
								csvReadertFileInputDelimited_11.readNext();
							}
							csvReadertFileInputDelimited_11.setSkipEmptyRecords(true);
							while (csvReadertFileInputDelimited_11.readNext()) {

								rowtFileInputDelimited_11 = csvReadertFileInputDelimited_11.getValues();
								if (!(rowtFileInputDelimited_11.length == 1
										&& ("\015").equals(rowtFileInputDelimited_11[0]))) {// empty line when row
																							// separator is '\n'

									totalLinetFileInputDelimited_11++;

								}

							}
							int lastLineTemptFileInputDelimited_11 = totalLinetFileInputDelimited_11
									- footer_tFileInputDelimited_11 < 0 ? 0
											: totalLinetFileInputDelimited_11 - footer_tFileInputDelimited_11;
							if (lastLinetFileInputDelimited_11 > 0) {
								lastLinetFileInputDelimited_11 = lastLinetFileInputDelimited_11 < lastLineTemptFileInputDelimited_11
										? lastLinetFileInputDelimited_11
										: lastLineTemptFileInputDelimited_11;
							} else {
								lastLinetFileInputDelimited_11 = lastLineTemptFileInputDelimited_11;
							}

							csvReadertFileInputDelimited_11.close();
							if (filename_tFileInputDelimited_11 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_11 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_11,
										fieldSeparator_tFileInputDelimited_11[0], "ISO-8859-15");
							} else {
								csvReadertFileInputDelimited_11 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_11),
										fieldSeparator_tFileInputDelimited_11[0], "ISO-8859-15");
							}
							csvReadertFileInputDelimited_11.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_11[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_11[0] != '\r'))
								csvReadertFileInputDelimited_11.setLineEnd("" + rowSeparator_tFileInputDelimited_11[0]);

							csvReadertFileInputDelimited_11.setQuoteChar('"');

							csvReadertFileInputDelimited_11
									.setEscapeChar(csvReadertFileInputDelimited_11.getQuoteChar());

						}

						if (limittFileInputDelimited_11 != 0) {
							for (currentLinetFileInputDelimited_11 = 0; currentLinetFileInputDelimited_11 < 1; currentLinetFileInputDelimited_11++) {
								csvReadertFileInputDelimited_11.readNext();
							}
						}
						csvReadertFileInputDelimited_11.setSkipEmptyRecords(true);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_11 != 0 && csvReadertFileInputDelimited_11 != null
							&& csvReadertFileInputDelimited_11.readNext()) {
						rowstate_tFileInputDelimited_11.reset();

						rowtFileInputDelimited_11 = csvReadertFileInputDelimited_11.getValues();

						if (rowtFileInputDelimited_11.length == 1 && ("\015").equals(rowtFileInputDelimited_11[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'
							continue;
						}

						currentLinetFileInputDelimited_11++;

						if (lastLinetFileInputDelimited_11 > -1
								&& currentLinetFileInputDelimited_11 > lastLinetFileInputDelimited_11) {
							break;
						}
						outputLinetFileInputDelimited_11++;
						if (limittFileInputDelimited_11 > 0
								&& outputLinetFileInputDelimited_11 > limittFileInputDelimited_11) {
							break;
						}

						row7 = null;

						boolean whetherReject_tFileInputDelimited_11 = false;
						row7 = new row7Struct();
						try {

							char fieldSeparator_tFileInputDelimited_11_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_11_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_11.length == 1
									&& ("\015").equals(rowtFileInputDelimited_11[0])) {// empty line when row separator
																						// is '\n'

								row7.zone_id = null;

								row7.zone_nom = null;

								row7.ville = null;

								row7.region = null;

								row7.pays = null;

								row7.lat_centre = null;

								row7.lon_centre = null;

								row7.surface_km2 = null;

								row7.population_estimee = null;

								row7.code_insee_commune = null;

								row7.note_admin = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_11 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_11 = 0;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.zone_id = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.zone_id = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 1;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.zone_nom = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.zone_nom = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 2;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.ville = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.ville = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 3;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.region = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.region = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 4;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.pays = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.pays = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 5;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.lat_centre = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.lat_centre = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 6;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.lon_centre = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.lon_centre = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 7;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.surface_km2 = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.surface_km2 = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 8;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.population_estimee = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.population_estimee = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 9;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.code_insee_commune = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.code_insee_commune = null;

								}

								columnIndexWithD_tFileInputDelimited_11 = 10;

								if (columnIndexWithD_tFileInputDelimited_11 < rowtFileInputDelimited_11.length) {

									row7.note_admin = rowtFileInputDelimited_11[columnIndexWithD_tFileInputDelimited_11];

								} else {

									row7.note_admin = null;

								}

							}

							if (rowstate_tFileInputDelimited_11.getException() != null) {
								throw rowstate_tFileInputDelimited_11.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_11 = true;

							System.err.println(e.getMessage());
							row7 = null;

							globalMap.put("tFileInputDelimited_11_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_11 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_11 main ] start
						 */

						currentComponent = "tFileInputDelimited_11";

						tos_count_tFileInputDelimited_11++;

						/**
						 * [tFileInputDelimited_11 main ] stop
						 */

						/**
						 * [tFileInputDelimited_11 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_11";

						/**
						 * [tFileInputDelimited_11 process_data_begin ] stop
						 */
// Start of branch "row7"
						if (row7 != null) {

							/**
							 * [tDBOutput_11 main ] start
							 */

							currentComponent = "tDBOutput_11";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row7"

								);
							}

							whetherReject_tDBOutput_11 = false;
							if (row7.zone_id == null) {
								pstmt_tDBOutput_11.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(1, row7.zone_id);
							}

							if (row7.zone_nom == null) {
								pstmt_tDBOutput_11.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(2, row7.zone_nom);
							}

							if (row7.ville == null) {
								pstmt_tDBOutput_11.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(3, row7.ville);
							}

							if (row7.region == null) {
								pstmt_tDBOutput_11.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(4, row7.region);
							}

							if (row7.pays == null) {
								pstmt_tDBOutput_11.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(5, row7.pays);
							}

							if (row7.lat_centre == null) {
								pstmt_tDBOutput_11.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(6, row7.lat_centre);
							}

							if (row7.lon_centre == null) {
								pstmt_tDBOutput_11.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(7, row7.lon_centre);
							}

							if (row7.surface_km2 == null) {
								pstmt_tDBOutput_11.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(8, row7.surface_km2);
							}

							if (row7.population_estimee == null) {
								pstmt_tDBOutput_11.setNull(9, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(9, row7.population_estimee);
							}

							if (row7.code_insee_commune == null) {
								pstmt_tDBOutput_11.setNull(10, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(10, row7.code_insee_commune);
							}

							if (row7.note_admin == null) {
								pstmt_tDBOutput_11.setNull(11, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_11.setString(11, row7.note_admin);
							}

							pstmt_tDBOutput_11.addBatch();
							nb_line_tDBOutput_11++;

							batchSizeCounter_tDBOutput_11++;

							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_11 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_11)
										throws Exception {
									try {

										for (int countEach_tDBOutput_11 : pstmt_tDBOutput_11.executeBatch()) {
											if (countEach_tDBOutput_11 == -2 || countEach_tDBOutput_11 == -3) {
												break;
											}
											counter += countEach_tDBOutput_11;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_11_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_11 = 0;
										for (int countEach_tDBOutput_11 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_11)
										throws Exception {
									try {

										for (int countEach_tDBOutput_11 : pstmt_tDBOutput_11.executeBatch()) {
											if (countEach_tDBOutput_11 == -2 || countEach_tDBOutput_11 == -3) {
												break;
											}
											counter += countEach_tDBOutput_11;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_11_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_11 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_11 > 0)
									&& (batchSize_tDBOutput_11 <= batchSizeCounter_tDBOutput_11)) {

								insertedCount_tDBOutput_11 = new LimitBytesHelper_tDBOutput_11()
										.limitBytePart1(insertedCount_tDBOutput_11, pstmt_tDBOutput_11);
								rowsToCommitCount_tDBOutput_11 = insertedCount_tDBOutput_11;

								batchSizeCounter_tDBOutput_11 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_11++;
							if (commitEvery_tDBOutput_11 <= commitCounter_tDBOutput_11) {
								if ((batchSize_tDBOutput_11 > 0) && (batchSizeCounter_tDBOutput_11 > 0)) {

									insertedCount_tDBOutput_11 = new LimitBytesHelper_tDBOutput_11()
											.limitBytePart1(insertedCount_tDBOutput_11, pstmt_tDBOutput_11);

									batchSizeCounter_tDBOutput_11 = 0;
								}
								if (rowsToCommitCount_tDBOutput_11 != 0) {

								}
								conn_tDBOutput_11.commit();
								if (rowsToCommitCount_tDBOutput_11 != 0) {

									rowsToCommitCount_tDBOutput_11 = 0;
								}
								commitCounter_tDBOutput_11 = 0;
							}

							tos_count_tDBOutput_11++;

							/**
							 * [tDBOutput_11 main ] stop
							 */

							/**
							 * [tDBOutput_11 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_11";

							/**
							 * [tDBOutput_11 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_11 process_data_end ] start
							 */

							currentComponent = "tDBOutput_11";

							/**
							 * [tDBOutput_11 process_data_end ] stop
							 */

						} // End of branch "row7"

						/**
						 * [tFileInputDelimited_11 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_11";

						/**
						 * [tFileInputDelimited_11 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_11 end ] start
						 */

						currentComponent = "tFileInputDelimited_11";

						nb_line_tFileInputDelimited_11++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_11 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_11 != null) {
							csvReadertFileInputDelimited_11.close();
						}
					}
					if (csvReadertFileInputDelimited_11 != null) {
						globalMap.put("tFileInputDelimited_11_NB_LINE", nb_line_tFileInputDelimited_11);
					}

				}

				ok_Hash.put("tFileInputDelimited_11", true);
				end_Hash.put("tFileInputDelimited_11", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_11 end ] stop
				 */

				/**
				 * [tDBOutput_11 end ] start
				 */

				currentComponent = "tDBOutput_11";

				try {
					int countSum_tDBOutput_11 = 0;
					if (pstmt_tDBOutput_11 != null && batchSizeCounter_tDBOutput_11 > 0) {

						for (int countEach_tDBOutput_11 : pstmt_tDBOutput_11.executeBatch()) {
							if (countEach_tDBOutput_11 == -2 || countEach_tDBOutput_11 == -3) {
								break;
							}
							countSum_tDBOutput_11 += countEach_tDBOutput_11;
						}
						rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;

					}

					insertedCount_tDBOutput_11 += countSum_tDBOutput_11;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_11_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_11 = 0;
					for (int countEach_tDBOutput_11 : e.getUpdateCounts()) {
						countSum_tDBOutput_11 += (countEach_tDBOutput_11 < 0 ? 0 : countEach_tDBOutput_11);
					}
					rowsToCommitCount_tDBOutput_11 += countSum_tDBOutput_11;

					insertedCount_tDBOutput_11 += countSum_tDBOutput_11;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_11 != null) {

					pstmt_tDBOutput_11.close();
					resourceMap.remove("pstmt_tDBOutput_11");

				}
				resourceMap.put("statementClosed_tDBOutput_11", true);
				if (rowsToCommitCount_tDBOutput_11 != 0) {

				}
				conn_tDBOutput_11.commit();
				if (rowsToCommitCount_tDBOutput_11 != 0) {

					rowsToCommitCount_tDBOutput_11 = 0;
				}
				commitCounter_tDBOutput_11 = 0;
				conn_tDBOutput_11.close();
				resourceMap.put("finish_tDBOutput_11", true);

				nb_line_deleted_tDBOutput_11 = nb_line_deleted_tDBOutput_11 + deletedCount_tDBOutput_11;
				nb_line_update_tDBOutput_11 = nb_line_update_tDBOutput_11 + updatedCount_tDBOutput_11;
				nb_line_inserted_tDBOutput_11 = nb_line_inserted_tDBOutput_11 + insertedCount_tDBOutput_11;
				nb_line_rejected_tDBOutput_11 = nb_line_rejected_tDBOutput_11 + rejectedCount_tDBOutput_11;

				globalMap.put("tDBOutput_11_NB_LINE", nb_line_tDBOutput_11);
				globalMap.put("tDBOutput_11_NB_LINE_UPDATED", nb_line_update_tDBOutput_11);
				globalMap.put("tDBOutput_11_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_11);
				globalMap.put("tDBOutput_11_NB_LINE_DELETED", nb_line_deleted_tDBOutput_11);
				globalMap.put("tDBOutput_11_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_11);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
				}

				ok_Hash.put("tDBOutput_11", true);
				end_Hash.put("tDBOutput_11", System.currentTimeMillis());

				/**
				 * [tDBOutput_11 end ] stop
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
				 * [tFileInputDelimited_11 finally ] start
				 */

				currentComponent = "tFileInputDelimited_11";

				/**
				 * [tFileInputDelimited_11 finally ] stop
				 */

				/**
				 * [tDBOutput_11 finally ] start
				 */

				currentComponent = "tDBOutput_11";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_11") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_11 = null;
						if ((pstmtToClose_tDBOutput_11 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_11")) != null) {
							pstmtToClose_tDBOutput_11.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_11") == null) {
						java.sql.Connection ctn_tDBOutput_11 = null;
						if ((ctn_tDBOutput_11 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_11")) != null) {
							try {
								ctn_tDBOutput_11.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_11) {
								String errorMessage_tDBOutput_11 = "failed to close the connection in tDBOutput_11 :"
										+ sqlEx_tDBOutput_11.getMessage();
								System.err.println(errorMessage_tDBOutput_11);
							}
						}
					}
				}

				/**
				 * [tDBOutput_11 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", 1);
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
		final loadarretstostaging loadarretstostagingClass = new loadarretstostaging();

		int exitCode = loadarretstostagingClass.runJobInTOS(args);

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
			java.io.InputStream inContext = loadarretstostaging.class.getClassLoader().getResourceAsStream(
					"local_project/loadarretstostaging_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = loadarretstostaging.class.getClassLoader()
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
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_4Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_4) {
			globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_4.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_7Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_7) {
			globalMap.put("tFileInputDelimited_7_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_7.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_8Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_8) {
			globalMap.put("tFileInputDelimited_8_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_8.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_9Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_9) {
			globalMap.put("tFileInputDelimited_9_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_9.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_10Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_10) {
			globalMap.put("tFileInputDelimited_10_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_10.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_11Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_11) {
			globalMap.put("tFileInputDelimited_11_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_11.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : loadarretstostaging");
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
 * 295730 characters generated by Talend Open Studio for Data Integration on the
 * 23 février 2026 à 13:04:49 WAT
 ************************************************************************************************/