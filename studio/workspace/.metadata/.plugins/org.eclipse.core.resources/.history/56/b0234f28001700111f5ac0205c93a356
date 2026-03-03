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

package local_project.loadxmltostaging_0_1;

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
 * Job: loadxmltostaging Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class loadxmltostaging implements TalendJob {

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
	private final String jobName = "loadxmltostaging";
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
					loadxmltostaging.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(loadxmltostaging.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFileInputXML_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputXML_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputXML_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputXML_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[0];

		public String accident_id;

		public String getAccident_id() {
			return this.accident_id;
		}

		public String time_id;

		public String getTime_id() {
			return this.time_id;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String lat;

		public String getLat() {
			return this.lat;
		}

		public String lon;

		public String getLon() {
			return this.lon;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String gravite;

		public String getGravite() {
			return this.gravite;
		}

		public String usager_vulnerable;

		public String getUsager_vulnerable() {
			return this.usager_vulnerable;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadxmltostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadxmltostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadxmltostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadxmltostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging) {

				try {

					int length = 0;

					this.accident_id = readString(dis);

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.lat = readString(dis);

					this.lon = readString(dis);

					this.type = readString(dis);

					this.gravite = readString(dis);

					this.usager_vulnerable = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging) {

				try {

					int length = 0;

					this.accident_id = readString(dis);

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.lat = readString(dis);

					this.lon = readString(dis);

					this.type = readString(dis);

					this.gravite = readString(dis);

					this.usager_vulnerable = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.accident_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.lat, dos);

				// String

				writeString(this.lon, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.gravite, dos);

				// String

				writeString(this.usager_vulnerable, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.accident_id, dos);

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.lat, dos);

				// String

				writeString(this.lon, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.gravite, dos);

				// String

				writeString(this.usager_vulnerable, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("accident_id=" + accident_id);
			sb.append(",time_id=" + time_id);
			sb.append(",zone_id=" + zone_id);
			sb.append(",lat=" + lat);
			sb.append(",lon=" + lon);
			sb.append(",type=" + type);
			sb.append(",gravite=" + gravite);
			sb.append(",usager_vulnerable=" + usager_vulnerable);
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

	public void tFileInputXML_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 0);

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
				dbschema_tDBOutput_1 = "";
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
						"enc:routine.encryption.key.v1:+ovRF4j63PmCRXW3cqfAu8ZcqaZ306CbbB9nbjKEuqG9FA==");

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
					tableName_tDBOutput_1 = "stagingaccidents";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "stagingaccidents";
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
						+ "] ([accident_id],[time_id],[zone_id],[lat],[lon],[type],[gravite],[usager_vulnerable]) VALUES (?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tFileInputXML_1 begin ] start
				 */

				ok_Hash.put("tFileInputXML_1", false);
				start_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				currentComponent = "tFileInputXML_1";

				int tos_count_tFileInputXML_1 = 0;

				int nb_line_tFileInputXML_1 = 0;

				String os_tFileInputXML_1 = System.getProperty("os.name").toLowerCase();
				boolean isWindows_tFileInputXML_1 = false;
				if (os_tFileInputXML_1.indexOf("windows") > -1 || os_tFileInputXML_1.indexOf("nt") > -1) {
					isWindows_tFileInputXML_1 = true;
				}
				class NameSpaceTool_tFileInputXML_1 {

					public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();

					private java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();

					public void countNSMap(org.dom4j.Element el) {
						for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {
							if (ns.getPrefix().trim().length() == 0) {
								xmlNameSpaceMap.put("pre" + defualtNSPath.size(), ns.getURI());
								String path = "";
								org.dom4j.Element elTmp = el;
								while (elTmp != null) {
									if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {
										path = "/" + elTmp.getNamespacePrefix() + ":" + elTmp.getName() + path;
									} else {
										path = "/" + elTmp.getName() + path;
									}
									elTmp = elTmp.getParent();
								}
								defualtNSPath.add(path);
							} else {
								xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());
							}

						}
						for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {
							countNSMap(e);
						}
					}

					private final org.talend.xpath.XPathUtil util = new org.talend.xpath.XPathUtil();

					{
						util.setDefaultNSPath(defualtNSPath);
					}

					public String addDefaultNSPrefix(String path) {
						return util.addDefaultNSPrefix(path);
					}

					public String addDefaultNSPrefix(String relativeXpression, String basePath) {
						return util.addDefaultNSPrefix(relativeXpression, basePath);
					}

				}

				class XML_API_tFileInputXML_1 {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}

				org.dom4j.io.SAXReader reader_tFileInputXML_1 = new org.dom4j.io.SAXReader();
				Object filename_tFileInputXML_1 = null;
				try {
					filename_tFileInputXML_1 = "C:/OneDrive_2026-01-21/Urban Mobility/data/accidents.xml";
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());

				}
				if (filename_tFileInputXML_1 != null && filename_tFileInputXML_1 instanceof String
						&& filename_tFileInputXML_1.toString().startsWith("//")) {
					if (!isWindows_tFileInputXML_1) {
						filename_tFileInputXML_1 = filename_tFileInputXML_1.toString().replaceFirst("//", "/");
					}
				}

				boolean isValidFile_tFileInputXML_1 = true;
				org.dom4j.Document doc_tFileInputXML_1 = null;
				java.io.Closeable toClose_tFileInputXML_1 = null;
				try {
					if (filename_tFileInputXML_1 instanceof java.io.InputStream) {
						java.io.InputStream inputStream_tFileInputXML_1 = (java.io.InputStream) filename_tFileInputXML_1;
						toClose_tFileInputXML_1 = inputStream_tFileInputXML_1;
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(inputStream_tFileInputXML_1);
					} else {
						java.io.Reader unicodeReader_tFileInputXML_1 = new UnicodeReader(
								new java.io.FileInputStream(String.valueOf(filename_tFileInputXML_1)), "ISO-8859-15");
						toClose_tFileInputXML_1 = unicodeReader_tFileInputXML_1;
						org.xml.sax.InputSource in_tFileInputXML_1 = new org.xml.sax.InputSource(
								unicodeReader_tFileInputXML_1);
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(in_tFileInputXML_1);
					}
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());
					isValidFile_tFileInputXML_1 = false;
				} finally {
					if (toClose_tFileInputXML_1 != null) {
						toClose_tFileInputXML_1.close();
					}
				}
				if (isValidFile_tFileInputXML_1) {
					NameSpaceTool_tFileInputXML_1 nsTool_tFileInputXML_1 = new NameSpaceTool_tFileInputXML_1();
					nsTool_tFileInputXML_1.countNSMap(doc_tFileInputXML_1.getRootElement());
					java.util.HashMap<String, String> xmlNameSpaceMap_tFileInputXML_1 = nsTool_tFileInputXML_1.xmlNameSpaceMap;

					org.dom4j.XPath x_tFileInputXML_1 = doc_tFileInputXML_1
							.createXPath(nsTool_tFileInputXML_1.addDefaultNSPrefix("/Accidents/Accident"));
					x_tFileInputXML_1.setNamespaceURIs(xmlNameSpaceMap_tFileInputXML_1);

					java.util.List<org.dom4j.Node> nodeList_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) x_tFileInputXML_1
							.selectNodes(doc_tFileInputXML_1);
					XML_API_tFileInputXML_1 xml_api_tFileInputXML_1 = new XML_API_tFileInputXML_1();
					String str_tFileInputXML_1 = "";
					org.dom4j.Node node_tFileInputXML_1 = null;

//init all mapping xpaths
					java.util.Map<Integer, org.dom4j.XPath> xpaths_tFileInputXML_1 = new java.util.HashMap<Integer, org.dom4j.XPath>();
					class XPathUtil_tFileInputXML_1 {

						public void initXPaths_0(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							org.dom4j.XPath xpath_0 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("accident_id", "/Accidents/Accident"));
							xpath_0.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(0, xpath_0);

							org.dom4j.XPath xpath_1 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("time_id", "/Accidents/Accident"));
							xpath_1.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(1, xpath_1);

							org.dom4j.XPath xpath_2 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("zone_id", "/Accidents/Accident"));
							xpath_2.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(2, xpath_2);

							org.dom4j.XPath xpath_3 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("lat", "/Accidents/Accident"));
							xpath_3.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(3, xpath_3);

							org.dom4j.XPath xpath_4 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("lon", "/Accidents/Accident"));
							xpath_4.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(4, xpath_4);

							org.dom4j.XPath xpath_5 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("type", "/Accidents/Accident"));
							xpath_5.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(5, xpath_5);

							org.dom4j.XPath xpath_6 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("gravite", "/Accidents/Accident"));
							xpath_6.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(6, xpath_6);

							org.dom4j.XPath xpath_7 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("usager_vulnerable", "/Accidents/Accident"));
							xpath_7.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(7, xpath_7);

						}

						public void initXPaths(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							initXPaths_0(xpaths, nsTool, xmlNameSpaceMap);

						}
					}
					XPathUtil_tFileInputXML_1 xPathUtil_tFileInputXML_1 = new XPathUtil_tFileInputXML_1();
					xPathUtil_tFileInputXML_1.initXPaths(xpaths_tFileInputXML_1, nsTool_tFileInputXML_1,
							xmlNameSpaceMap_tFileInputXML_1);
					for (org.dom4j.Node temp_tFileInputXML_1 : nodeList_tFileInputXML_1) {
						nb_line_tFileInputXML_1++;

						row1 = null;
						boolean whetherReject_tFileInputXML_1 = false;
						row1 = new row1Struct();
						try {
							Object obj0_tFileInputXML_1 = xpaths_tFileInputXML_1.get(0).evaluate(temp_tFileInputXML_1);
							if (obj0_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj0_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj0_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj0_tFileInputXML_1 instanceof String
									|| obj0_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj0_tFileInputXML_1);
							} else if (obj0_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj0_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.accident_id = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.accident_id = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.accident_id = null;
							} else {
								row1.accident_id = str_tFileInputXML_1;
							}
							Object obj1_tFileInputXML_1 = xpaths_tFileInputXML_1.get(1).evaluate(temp_tFileInputXML_1);
							if (obj1_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj1_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj1_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj1_tFileInputXML_1 instanceof String
									|| obj1_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj1_tFileInputXML_1);
							} else if (obj1_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj1_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.time_id = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.time_id = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.time_id = null;
							} else {
								row1.time_id = str_tFileInputXML_1;
							}
							Object obj2_tFileInputXML_1 = xpaths_tFileInputXML_1.get(2).evaluate(temp_tFileInputXML_1);
							if (obj2_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj2_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj2_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj2_tFileInputXML_1 instanceof String
									|| obj2_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj2_tFileInputXML_1);
							} else if (obj2_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj2_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.zone_id = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.zone_id = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.zone_id = null;
							} else {
								row1.zone_id = str_tFileInputXML_1;
							}
							Object obj3_tFileInputXML_1 = xpaths_tFileInputXML_1.get(3).evaluate(temp_tFileInputXML_1);
							if (obj3_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj3_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj3_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj3_tFileInputXML_1 instanceof String
									|| obj3_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj3_tFileInputXML_1);
							} else if (obj3_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj3_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.lat = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.lat = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.lat = null;
							} else {
								row1.lat = str_tFileInputXML_1;
							}
							Object obj4_tFileInputXML_1 = xpaths_tFileInputXML_1.get(4).evaluate(temp_tFileInputXML_1);
							if (obj4_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj4_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj4_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj4_tFileInputXML_1 instanceof String
									|| obj4_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj4_tFileInputXML_1);
							} else if (obj4_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj4_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.lon = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.lon = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.lon = null;
							} else {
								row1.lon = str_tFileInputXML_1;
							}
							Object obj5_tFileInputXML_1 = xpaths_tFileInputXML_1.get(5).evaluate(temp_tFileInputXML_1);
							if (obj5_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj5_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj5_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj5_tFileInputXML_1 instanceof String
									|| obj5_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj5_tFileInputXML_1);
							} else if (obj5_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj5_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.type = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.type = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.type = null;
							} else {
								row1.type = str_tFileInputXML_1;
							}
							Object obj6_tFileInputXML_1 = xpaths_tFileInputXML_1.get(6).evaluate(temp_tFileInputXML_1);
							if (obj6_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj6_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj6_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj6_tFileInputXML_1 instanceof String
									|| obj6_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj6_tFileInputXML_1);
							} else if (obj6_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj6_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.gravite = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.gravite = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.gravite = null;
							} else {
								row1.gravite = str_tFileInputXML_1;
							}
							Object obj7_tFileInputXML_1 = xpaths_tFileInputXML_1.get(7).evaluate(temp_tFileInputXML_1);
							if (obj7_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj7_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj7_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj7_tFileInputXML_1 instanceof String
									|| obj7_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj7_tFileInputXML_1);
							} else if (obj7_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj7_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row1.usager_vulnerable = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row1.usager_vulnerable = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row1.usager_vulnerable = null;
							} else {
								row1.usager_vulnerable = str_tFileInputXML_1;
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputXML_1 = true;
							System.err.println(e.getMessage());
							row1 = null;
						}

						/**
						 * [tFileInputXML_1 begin ] stop
						 */

						/**
						 * [tFileInputXML_1 main ] start
						 */

						currentComponent = "tFileInputXML_1";

						tos_count_tFileInputXML_1++;

						/**
						 * [tFileInputXML_1 main ] stop
						 */

						/**
						 * [tFileInputXML_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_begin ] stop
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
							if (row1.accident_id == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(1, row1.accident_id);
							}

							if (row1.time_id == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, row1.time_id);
							}

							if (row1.zone_id == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, row1.zone_id);
							}

							if (row1.lat == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, row1.lat);
							}

							if (row1.lon == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(5, row1.lon);
							}

							if (row1.type == null) {
								pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(6, row1.type);
							}

							if (row1.gravite == null) {
								pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(7, row1.gravite);
							}

							if (row1.usager_vulnerable == null) {
								pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(8, row1.usager_vulnerable);
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
						 * [tFileInputXML_1 process_data_end ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputXML_1 end ] start
						 */

						currentComponent = "tFileInputXML_1";

					}
				}
				globalMap.put("tFileInputXML_1_NB_LINE", nb_line_tFileInputXML_1);

				ok_Hash.put("tFileInputXML_1", true);
				end_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				/**
				 * [tFileInputXML_1 end ] stop
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
				 * [tFileInputXML_1 finally ] start
				 */

				currentComponent = "tFileInputXML_1";

				/**
				 * [tFileInputXML_1 finally ] stop
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

		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[0];

		public String aq_id;

		public String getAq_id() {
			return this.aq_id;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String pm25_ugm3;

		public String getPm25_ugm3() {
			return this.pm25_ugm3;
		}

		public String no2_ugm3;

		public String getNo2_ugm3() {
			return this.no2_ugm3;
		}

		public String aqi_index;

		public String getAqi_index() {
			return this.aqi_index;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_loadxmltostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadxmltostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_loadxmltostaging.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_loadxmltostaging.length == 0) {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_loadxmltostaging = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_loadxmltostaging, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging) {

				try {

					int length = 0;

					this.aq_id = readString(dis);

					this.date = readString(dis);

					this.zone_id = readString(dis);

					this.pm25_ugm3 = readString(dis);

					this.no2_ugm3 = readString(dis);

					this.aqi_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_loadxmltostaging) {

				try {

					int length = 0;

					this.aq_id = readString(dis);

					this.date = readString(dis);

					this.zone_id = readString(dis);

					this.pm25_ugm3 = readString(dis);

					this.no2_ugm3 = readString(dis);

					this.aqi_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.aq_id, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.pm25_ugm3, dos);

				// String

				writeString(this.no2_ugm3, dos);

				// String

				writeString(this.aqi_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.aq_id, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.pm25_ugm3, dos);

				// String

				writeString(this.no2_ugm3, dos);

				// String

				writeString(this.aqi_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("aq_id=" + aq_id);
			sb.append(",date=" + date);
			sb.append(",zone_id=" + zone_id);
			sb.append(",pm25_ugm3=" + pm25_ugm3);
			sb.append(",no2_ugm3=" + no2_ugm3);
			sb.append(",aqi_index=" + aqi_index);
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

	public void tFileInputXML_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputXML_2_SUBPROCESS_STATE", 0);

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
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
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

				java.sql.Connection conn_tDBOutput_2 = null;
				String dbUser_tDBOutput_2 = null;
				dbschema_tDBOutput_2 = "";
				String driverClass_tDBOutput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

				java.lang.Class.forName(driverClass_tDBOutput_2);
				String port_tDBOutput_2 = "1433";
				String dbname_tDBOutput_2 = "UrbanMobility";
				String url_tDBOutput_2 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBOutput_2)) {
					url_tDBOutput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_2)) {
					url_tDBOutput_2 += ";databaseName=" + "UrbanMobility";

				}
				url_tDBOutput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				dbUser_tDBOutput_2 = "miming";

				final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:XuwTIuv6ufasqH1SsHsRrhYHI9hYwWUV2CYjgBXq1JYvFg==");

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
					tableName_tDBOutput_2 = "staging_air_quality";
				} else {
					tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].[" + "staging_air_quality";
				}
				int count_tDBOutput_2 = 0;

				int rsTruncCountNumber_tDBOutput_2 = 0;
				try (java.sql.Statement stmtTruncCount_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
					try (java.sql.ResultSet rsTruncCount_tDBOutput_2 = stmtTruncCount_tDBOutput_2
							.executeQuery("SELECT COUNT(1) FROM [" + tableName_tDBOutput_2 + "]")) {
						if (rsTruncCount_tDBOutput_2.next()) {
							rsTruncCountNumber_tDBOutput_2 = rsTruncCount_tDBOutput_2.getInt(1);
						}
					}
				}
				try (java.sql.Statement stmtTrunc_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
					stmtTrunc_tDBOutput_2.executeUpdate("TRUNCATE TABLE [" + tableName_tDBOutput_2 + "]");
					deletedCount_tDBOutput_2 += rsTruncCountNumber_tDBOutput_2;
				}
				String insert_tDBOutput_2 = "INSERT INTO [" + tableName_tDBOutput_2
						+ "] ([aq_id],[date],[zone_id],[pm25_ugm3],[no2_ugm3],[aqi_index]) VALUES (?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tFileInputXML_2 begin ] start
				 */

				ok_Hash.put("tFileInputXML_2", false);
				start_Hash.put("tFileInputXML_2", System.currentTimeMillis());

				currentComponent = "tFileInputXML_2";

				int tos_count_tFileInputXML_2 = 0;

				int nb_line_tFileInputXML_2 = 0;

				String os_tFileInputXML_2 = System.getProperty("os.name").toLowerCase();
				boolean isWindows_tFileInputXML_2 = false;
				if (os_tFileInputXML_2.indexOf("windows") > -1 || os_tFileInputXML_2.indexOf("nt") > -1) {
					isWindows_tFileInputXML_2 = true;
				}
				class NameSpaceTool_tFileInputXML_2 {

					public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();

					private java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();

					public void countNSMap(org.dom4j.Element el) {
						for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {
							if (ns.getPrefix().trim().length() == 0) {
								xmlNameSpaceMap.put("pre" + defualtNSPath.size(), ns.getURI());
								String path = "";
								org.dom4j.Element elTmp = el;
								while (elTmp != null) {
									if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {
										path = "/" + elTmp.getNamespacePrefix() + ":" + elTmp.getName() + path;
									} else {
										path = "/" + elTmp.getName() + path;
									}
									elTmp = elTmp.getParent();
								}
								defualtNSPath.add(path);
							} else {
								xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());
							}

						}
						for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {
							countNSMap(e);
						}
					}

					private final org.talend.xpath.XPathUtil util = new org.talend.xpath.XPathUtil();

					{
						util.setDefaultNSPath(defualtNSPath);
					}

					public String addDefaultNSPrefix(String path) {
						return util.addDefaultNSPrefix(path);
					}

					public String addDefaultNSPrefix(String relativeXpression, String basePath) {
						return util.addDefaultNSPrefix(relativeXpression, basePath);
					}

				}

				class XML_API_tFileInputXML_2 {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}

				org.dom4j.io.SAXReader reader_tFileInputXML_2 = new org.dom4j.io.SAXReader();
				Object filename_tFileInputXML_2 = null;
				try {
					filename_tFileInputXML_2 = "C:/OneDrive_2026-01-21/Urban Mobility/data/qualite_air.xml";
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_2_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());

				}
				if (filename_tFileInputXML_2 != null && filename_tFileInputXML_2 instanceof String
						&& filename_tFileInputXML_2.toString().startsWith("//")) {
					if (!isWindows_tFileInputXML_2) {
						filename_tFileInputXML_2 = filename_tFileInputXML_2.toString().replaceFirst("//", "/");
					}
				}

				boolean isValidFile_tFileInputXML_2 = true;
				org.dom4j.Document doc_tFileInputXML_2 = null;
				java.io.Closeable toClose_tFileInputXML_2 = null;
				try {
					if (filename_tFileInputXML_2 instanceof java.io.InputStream) {
						java.io.InputStream inputStream_tFileInputXML_2 = (java.io.InputStream) filename_tFileInputXML_2;
						toClose_tFileInputXML_2 = inputStream_tFileInputXML_2;
						doc_tFileInputXML_2 = reader_tFileInputXML_2.read(inputStream_tFileInputXML_2);
					} else {
						java.io.Reader unicodeReader_tFileInputXML_2 = new UnicodeReader(
								new java.io.FileInputStream(String.valueOf(filename_tFileInputXML_2)), "ISO-8859-15");
						toClose_tFileInputXML_2 = unicodeReader_tFileInputXML_2;
						org.xml.sax.InputSource in_tFileInputXML_2 = new org.xml.sax.InputSource(
								unicodeReader_tFileInputXML_2);
						doc_tFileInputXML_2 = reader_tFileInputXML_2.read(in_tFileInputXML_2);
					}
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_2_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());
					isValidFile_tFileInputXML_2 = false;
				} finally {
					if (toClose_tFileInputXML_2 != null) {
						toClose_tFileInputXML_2.close();
					}
				}
				if (isValidFile_tFileInputXML_2) {
					NameSpaceTool_tFileInputXML_2 nsTool_tFileInputXML_2 = new NameSpaceTool_tFileInputXML_2();
					nsTool_tFileInputXML_2.countNSMap(doc_tFileInputXML_2.getRootElement());
					java.util.HashMap<String, String> xmlNameSpaceMap_tFileInputXML_2 = nsTool_tFileInputXML_2.xmlNameSpaceMap;

					org.dom4j.XPath x_tFileInputXML_2 = doc_tFileInputXML_2
							.createXPath(nsTool_tFileInputXML_2.addDefaultNSPrefix("/AirQuality/Record"));
					x_tFileInputXML_2.setNamespaceURIs(xmlNameSpaceMap_tFileInputXML_2);

					java.util.List<org.dom4j.Node> nodeList_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) x_tFileInputXML_2
							.selectNodes(doc_tFileInputXML_2);
					XML_API_tFileInputXML_2 xml_api_tFileInputXML_2 = new XML_API_tFileInputXML_2();
					String str_tFileInputXML_2 = "";
					org.dom4j.Node node_tFileInputXML_2 = null;

//init all mapping xpaths
					java.util.Map<Integer, org.dom4j.XPath> xpaths_tFileInputXML_2 = new java.util.HashMap<Integer, org.dom4j.XPath>();
					class XPathUtil_tFileInputXML_2 {

						public void initXPaths_0(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_2 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							org.dom4j.XPath xpath_0 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("aq_id", "/AirQuality/Record"));
							xpath_0.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(0, xpath_0);

							org.dom4j.XPath xpath_1 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("date", "/AirQuality/Record"));
							xpath_1.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(1, xpath_1);

							org.dom4j.XPath xpath_2 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("zone_id", "/AirQuality/Record"));
							xpath_2.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(2, xpath_2);

							org.dom4j.XPath xpath_3 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("pm25_ugm3", "/AirQuality/Record"));
							xpath_3.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(3, xpath_3);

							org.dom4j.XPath xpath_4 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("no2_ugm3", "/AirQuality/Record"));
							xpath_4.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(4, xpath_4);

							org.dom4j.XPath xpath_5 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("aqi_index", "/AirQuality/Record"));
							xpath_5.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(5, xpath_5);

						}

						public void initXPaths(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_2 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							initXPaths_0(xpaths, nsTool, xmlNameSpaceMap);

						}
					}
					XPathUtil_tFileInputXML_2 xPathUtil_tFileInputXML_2 = new XPathUtil_tFileInputXML_2();
					xPathUtil_tFileInputXML_2.initXPaths(xpaths_tFileInputXML_2, nsTool_tFileInputXML_2,
							xmlNameSpaceMap_tFileInputXML_2);
					for (org.dom4j.Node temp_tFileInputXML_2 : nodeList_tFileInputXML_2) {
						nb_line_tFileInputXML_2++;

						row2 = null;
						boolean whetherReject_tFileInputXML_2 = false;
						row2 = new row2Struct();
						try {
							Object obj0_tFileInputXML_2 = xpaths_tFileInputXML_2.get(0).evaluate(temp_tFileInputXML_2);
							if (obj0_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj0_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj0_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj0_tFileInputXML_2 instanceof String
									|| obj0_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj0_tFileInputXML_2);
							} else if (obj0_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj0_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.aq_id = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.aq_id = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.aq_id = null;
							} else {
								row2.aq_id = str_tFileInputXML_2;
							}
							Object obj1_tFileInputXML_2 = xpaths_tFileInputXML_2.get(1).evaluate(temp_tFileInputXML_2);
							if (obj1_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj1_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj1_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj1_tFileInputXML_2 instanceof String
									|| obj1_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj1_tFileInputXML_2);
							} else if (obj1_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj1_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.date = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.date = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.date = null;
							} else {
								row2.date = str_tFileInputXML_2;
							}
							Object obj2_tFileInputXML_2 = xpaths_tFileInputXML_2.get(2).evaluate(temp_tFileInputXML_2);
							if (obj2_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj2_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj2_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj2_tFileInputXML_2 instanceof String
									|| obj2_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj2_tFileInputXML_2);
							} else if (obj2_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj2_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.zone_id = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.zone_id = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.zone_id = null;
							} else {
								row2.zone_id = str_tFileInputXML_2;
							}
							Object obj3_tFileInputXML_2 = xpaths_tFileInputXML_2.get(3).evaluate(temp_tFileInputXML_2);
							if (obj3_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj3_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj3_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj3_tFileInputXML_2 instanceof String
									|| obj3_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj3_tFileInputXML_2);
							} else if (obj3_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj3_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.pm25_ugm3 = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.pm25_ugm3 = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.pm25_ugm3 = null;
							} else {
								row2.pm25_ugm3 = str_tFileInputXML_2;
							}
							Object obj4_tFileInputXML_2 = xpaths_tFileInputXML_2.get(4).evaluate(temp_tFileInputXML_2);
							if (obj4_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj4_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj4_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj4_tFileInputXML_2 instanceof String
									|| obj4_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj4_tFileInputXML_2);
							} else if (obj4_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj4_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.no2_ugm3 = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.no2_ugm3 = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.no2_ugm3 = null;
							} else {
								row2.no2_ugm3 = str_tFileInputXML_2;
							}
							Object obj5_tFileInputXML_2 = xpaths_tFileInputXML_2.get(5).evaluate(temp_tFileInputXML_2);
							if (obj5_tFileInputXML_2 == null) {
								node_tFileInputXML_2 = null;
								str_tFileInputXML_2 = "";

							} else if (obj5_tFileInputXML_2 instanceof org.dom4j.Node) {
								node_tFileInputXML_2 = (org.dom4j.Node) obj5_tFileInputXML_2;
								str_tFileInputXML_2 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj5_tFileInputXML_2 instanceof String
									|| obj5_tFileInputXML_2 instanceof Number) {
								node_tFileInputXML_2 = temp_tFileInputXML_2;
								str_tFileInputXML_2 = String.valueOf(obj5_tFileInputXML_2);
							} else if (obj5_tFileInputXML_2 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_2 = (java.util.List<org.dom4j.Node>) obj5_tFileInputXML_2;
								node_tFileInputXML_2 = nodes_tFileInputXML_2.size() > 0 ? nodes_tFileInputXML_2.get(0)
										: null;
								str_tFileInputXML_2 = node_tFileInputXML_2 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_2,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_2.isDefNull(node_tFileInputXML_2)) {
								row2.aqi_index = null;
							} else if (xml_api_tFileInputXML_2.isEmpty(node_tFileInputXML_2)) {
								row2.aqi_index = "";
							} else if (xml_api_tFileInputXML_2.isMissing(node_tFileInputXML_2)) {
								row2.aqi_index = null;
							} else {
								row2.aqi_index = str_tFileInputXML_2;
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputXML_2_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputXML_2 = true;
							System.err.println(e.getMessage());
							row2 = null;
						}

						/**
						 * [tFileInputXML_2 begin ] stop
						 */

						/**
						 * [tFileInputXML_2 main ] start
						 */

						currentComponent = "tFileInputXML_2";

						tos_count_tFileInputXML_2++;

						/**
						 * [tFileInputXML_2 main ] stop
						 */

						/**
						 * [tFileInputXML_2 process_data_begin ] start
						 */

						currentComponent = "tFileInputXML_2";

						/**
						 * [tFileInputXML_2 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {

							/**
							 * [tDBOutput_2 main ] start
							 */

							currentComponent = "tDBOutput_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							whetherReject_tDBOutput_2 = false;
							if (row2.aq_id == null) {
								pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(1, row2.aq_id);
							}

							if (row2.date == null) {
								pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(2, row2.date);
							}

							if (row2.zone_id == null) {
								pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(3, row2.zone_id);
							}

							if (row2.pm25_ugm3 == null) {
								pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(4, row2.pm25_ugm3);
							}

							if (row2.no2_ugm3 == null) {
								pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(5, row2.no2_ugm3);
							}

							if (row2.aqi_index == null) {
								pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(6, row2.aqi_index);
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

								insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
										.limitBytePart1(insertedCount_tDBOutput_2, pstmt_tDBOutput_2);
								rowsToCommitCount_tDBOutput_2 = insertedCount_tDBOutput_2;

								batchSizeCounter_tDBOutput_2 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_2++;
							if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
								if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {

									insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
											.limitBytePart1(insertedCount_tDBOutput_2, pstmt_tDBOutput_2);

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

						} // End of branch "row2"

						/**
						 * [tFileInputXML_2 process_data_end ] start
						 */

						currentComponent = "tFileInputXML_2";

						/**
						 * [tFileInputXML_2 process_data_end ] stop
						 */

						/**
						 * [tFileInputXML_2 end ] start
						 */

						currentComponent = "tFileInputXML_2";

					}
				}
				globalMap.put("tFileInputXML_2_NB_LINE", nb_line_tFileInputXML_2);

				ok_Hash.put("tFileInputXML_2", true);
				end_Hash.put("tFileInputXML_2", System.currentTimeMillis());

				/**
				 * [tFileInputXML_2 end ] stop
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

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
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

			try {

				/**
				 * [tFileInputXML_2 finally ] start
				 */

				currentComponent = "tFileInputXML_2";

				/**
				 * [tFileInputXML_2 finally ] stop
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

		globalMap.put("tFileInputXML_2_SUBPROCESS_STATE", 1);
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
		final loadxmltostaging loadxmltostagingClass = new loadxmltostaging();

		int exitCode = loadxmltostagingClass.runJobInTOS(args);

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
			java.io.InputStream inContext = loadxmltostaging.class.getClassLoader()
					.getResourceAsStream("local_project/loadxmltostaging_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = loadxmltostaging.class.getClassLoader()
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
			tFileInputXML_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputXML_1) {
			globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", -1);

			e_tFileInputXML_1.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputXML_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputXML_2) {
			globalMap.put("tFileInputXML_2_SUBPROCESS_STATE", -1);

			e_tFileInputXML_2.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : loadxmltostaging");
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
 * 110443 characters generated by Talend Open Studio for Data Integration on the
 * 8 février 2026 à 23:59:35 WAT
 ************************************************************************************************/