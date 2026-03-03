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

package local_project.facttrafic_0_1;

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
 * Job: facttrafic Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class facttrafic implements TalendJob {

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
	private final String jobName = "facttrafic";
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
					facttrafic.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(facttrafic.this, new Object[] { e, currentComponent, globalMap });
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

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAggregateRow_1_AGGOUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);

	}

	public void tAggregateRow_1_AGGIN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];

		public Float vitesse_kmh;

		public Float getVitesse_kmh() {
			return this.vitesse_kmh;
		}

		public Float temps_trajet_min;

		public Float getTemps_trajet_min() {
			return this.temps_trajet_min;
		}

		public Float congestion_index;

		public Float getCongestion_index() {
			return this.congestion_index;
		}

		public Integer fkzone_id;

		public Integer getFkzone_id() {
			return this.fkzone_id;
		}

		public Integer fkmeteo;

		public Integer getFkmeteo() {
			return this.fkmeteo;
		}

		public Integer fksensor;

		public Integer getFksensor() {
			return this.fksensor;
		}

		public Integer fkevent;

		public Integer getFkevent() {
			return this.fkevent;
		}

		public int date_id;

		public int getDate_id() {
			return this.date_id;
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

					this.fkzone_id = readInteger(dis);

					this.fkmeteo = readInteger(dis);

					this.fksensor = readInteger(dis);

					this.fkevent = readInteger(dis);

					this.date_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

					this.fkzone_id = readInteger(dis);

					this.fkmeteo = readInteger(dis);

					this.fksensor = readInteger(dis);

					this.fkevent = readInteger(dis);

					this.date_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

				// Integer

				writeInteger(this.fkzone_id, dos);

				// Integer

				writeInteger(this.fkmeteo, dos);

				// Integer

				writeInteger(this.fksensor, dos);

				// Integer

				writeInteger(this.fkevent, dos);

				// int

				dos.writeInt(this.date_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

				// Integer

				writeInteger(this.fkzone_id, dos);

				// Integer

				writeInteger(this.fkmeteo, dos);

				// Integer

				writeInteger(this.fksensor, dos);

				// Integer

				writeInteger(this.fkevent, dos);

				// int

				dos.writeInt(this.date_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("vitesse_kmh=" + String.valueOf(vitesse_kmh));
			sb.append(",temps_trajet_min=" + String.valueOf(temps_trajet_min));
			sb.append(",congestion_index=" + String.valueOf(congestion_index));
			sb.append(",fkzone_id=" + String.valueOf(fkzone_id));
			sb.append(",fkmeteo=" + String.valueOf(fkmeteo));
			sb.append(",fksensor=" + String.valueOf(fksensor));
			sb.append(",fkevent=" + String.valueOf(fkevent));
			sb.append(",date_id=" + String.valueOf(date_id));
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

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];

		public Integer time_id;

		public Integer getTime_id() {
			return this.time_id;
		}

		public Integer zone_id;

		public Integer getZone_id() {
			return this.zone_id;
		}

		public String source_sensor;

		public String getSource_sensor() {
			return this.source_sensor;
		}

		public Float vitesse_kmh;

		public Float getVitesse_kmh() {
			return this.vitesse_kmh;
		}

		public Float temps_trajet_min;

		public Float getTemps_trajet_min() {
			return this.temps_trajet_min;
		}

		public Float congestion_index;

		public Float getCongestion_index() {
			return this.congestion_index;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readInteger(dis);

					this.zone_id = readInteger(dis);

					this.source_sensor = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readInteger(dis);

					this.zone_id = readInteger(dis);

					this.source_sensor = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.time_id, dos);

				// Integer

				writeInteger(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.time_id, dos);

				// Integer

				writeInteger(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("time_id=" + String.valueOf(time_id));
			sb.append(",zone_id=" + String.valueOf(zone_id));
			sb.append(",source_sensor=" + source_sensor);
			sb.append(",vitesse_kmh=" + String.valueOf(vitesse_kmh));
			sb.append(",temps_trajet_min=" + String.valueOf(temps_trajet_min));
			sb.append(",congestion_index=" + String.valueOf(congestion_index));
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

	public static class OnRowsEndStructtAggregateRow_1
			implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];

		public Integer time_id;

		public Integer getTime_id() {
			return this.time_id;
		}

		public Integer zone_id;

		public Integer getZone_id() {
			return this.zone_id;
		}

		public String source_sensor;

		public String getSource_sensor() {
			return this.source_sensor;
		}

		public Float vitesse_kmh;

		public Float getVitesse_kmh() {
			return this.vitesse_kmh;
		}

		public Float temps_trajet_min;

		public Float getTemps_trajet_min() {
			return this.temps_trajet_min;
		}

		public Float congestion_index;

		public Float getCongestion_index() {
			return this.congestion_index;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readInteger(dis);

					this.zone_id = readInteger(dis);

					this.source_sensor = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readInteger(dis);

					this.zone_id = readInteger(dis);

					this.source_sensor = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.vitesse_kmh = null;
					} else {
						this.vitesse_kmh = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.temps_trajet_min = null;
					} else {
						this.temps_trajet_min = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.congestion_index = null;
					} else {
						this.congestion_index = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.time_id, dos);

				// Integer

				writeInteger(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.time_id, dos);

				// Integer

				writeInteger(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// Float

				if (this.vitesse_kmh == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.vitesse_kmh);
				}

				// Float

				if (this.temps_trajet_min == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.temps_trajet_min);
				}

				// Float

				if (this.congestion_index == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.congestion_index);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("time_id=" + String.valueOf(time_id));
			sb.append(",zone_id=" + String.valueOf(zone_id));
			sb.append(",source_sensor=" + source_sensor);
			sb.append(",vitesse_kmh=" + String.valueOf(vitesse_kmh));
			sb.append(",temps_trajet_min=" + String.valueOf(temps_trajet_min));
			sb.append(",congestion_index=" + String.valueOf(congestion_index));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];

		public String time_id;

		public String getTime_id() {
			return this.time_id;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String source_sensor;

		public String getSource_sensor() {
			return this.source_sensor;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.source_sensor = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.source_sensor = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("time_id=" + time_id);
			sb.append(",zone_id=" + zone_id);
			sb.append(",source_sensor=" + source_sensor);
			sb.append(",vitesse_kmh=" + vitesse_kmh);
			sb.append(",temps_trajet_min=" + temps_trajet_min);
			sb.append(",congestion_index=" + congestion_index);
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

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];

		public String time_id;

		public String getTime_id() {
			return this.time_id;
		}

		public String zone_id;

		public String getZone_id() {
			return this.zone_id;
		}

		public String source_sensor;

		public String getSource_sensor() {
			return this.source_sensor;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.source_sensor = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = readString(dis);

					this.zone_id = readString(dis);

					this.source_sensor = readString(dis);

					this.vitesse_kmh = readString(dis);

					this.temps_trajet_min = readString(dis);

					this.congestion_index = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.time_id, dos);

				// String

				writeString(this.zone_id, dos);

				// String

				writeString(this.source_sensor, dos);

				// String

				writeString(this.vitesse_kmh, dos);

				// String

				writeString(this.temps_trajet_min, dos);

				// String

				writeString(this.congestion_index, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("time_id=" + time_id);
			sb.append(",zone_id=" + zone_id);
			sb.append(",source_sensor=" + source_sensor);
			sb.append(",vitesse_kmh=" + vitesse_kmh);
			sb.append(",temps_trajet_min=" + temps_trajet_min);
			sb.append(",congestion_index=" + congestion_index);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

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

				tDBInput_2Process(globalMap);
				tDBInput_3Process(globalMap);
				tDBInput_4Process(globalMap);
				tDBInput_5Process(globalMap);
				tDBInput_6Process(globalMap);

				row1Struct row1 = new row1Struct();
				row7Struct row7 = new row7Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGOUT", false);
				start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tAggregateRow_1_AGGOUT = 0;

// ------------ Seems it is not used

				java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap();

// ------------

				class UtilClass_tAggregateRow_1 { // G_OutBegin_AggR_144

					public double sd(Double[] data) {
						final int n = data.length;
						if (n < 2) {
							return Double.NaN;
						}
						double d1 = 0d;
						double d2 = 0d;

						for (int i = 0; i < data.length; i++) {
							d1 += (data[i] * data[i]);
							d2 += data[i];
						}

						return Math.sqrt((n * d1 - d2 * d2) / n / (n - 1));
					}

					public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
						byte r = (byte) (a + b);
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'short/Short'", "'byte/Byte'"));
						}
					}

					public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
						short r = (short) (a + b);
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'int/Integer'", "'short/Short'"));
						}
					}

					public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
						int r = a + b;
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'long/Long'", "'int/Integer'"));
						}
					}

					public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
						long r = a + b;
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'long/Long'"));
						}
					}

					public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							float minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b),
										"'double' or 'BigDecimal'", "'float/Float'"));
							}
						}

						if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE)
								|| ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'double' or 'BigDecimal'", "'float/Float'"));
						}
					}

					public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							double minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a),
										"'BigDecimal'", "'double/Double'"));
							}
						}

						if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							double minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a),
										"'BigDecimal'", "'double/Double'"));
							}
						}

						if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
						return "Type overflow when adding " + b + " to " + a
								+ ", to resolve this problem, increase the precision by using " + advicedTypes
								+ " type in place of " + originalType + ".";
					}

					private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
						return "The double precision is unsufficient to add the value " + b + " to " + a
								+ ", to resolve this problem, increase the precision by using " + advicedTypes
								+ " type in place of " + originalType + ".";
					}

				} // G_OutBegin_AggR_144

				UtilClass_tAggregateRow_1 utilClass_tAggregateRow_1 = new UtilClass_tAggregateRow_1();

				class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String time_id;
					String zone_id;
					String source_sensor_first;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.time_id == null) ? 0 : this.time_id.hashCode());

							result = prime * result + ((this.zone_id == null) ? 0 : this.zone_id.hashCode());

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
						final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;

						if (this.time_id == null) {
							if (other.time_id != null)
								return false;
						} else if (!this.time_id.equals(other.time_id))
							return false;

						if (this.zone_id == null) {
							if (other.zone_id != null)
								return false;
						} else if (!this.zone_id.equals(other.zone_id))
							return false;

						return true;
					}

				} // G_OutBegin_AggR_100

				System.err.println(

						"Warning:the operation 'sum' for the output column 'congestion_index' can't be processed because of incompatible input and/or output types"
								+ "\n"
								+ "Warning:the operation 'avg' for the output column 'congestion_index' can't be processed because of incompatible input and/or output types"
								+ "\n"
								+ "Warning:the operation 'sum' for the output column 'vitesse_kmh' can't be processed because of incompatible input and/or output types"
								+ "\n"
								+ "Warning:the operation 'avg' for the output column 'vitesse_kmh' can't be processed because of incompatible input and/or output types"
								+ "\n"
								+ "Warning:the operation 'sum' for the output column 'temps_trajet_min' can't be processed because of incompatible input and/or output types"
								+ "\n"
								+ "Warning:the operation 'avg' for the output column 'temps_trajet_min' can't be processed because of incompatible input and/or output types");

				AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
				AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
				java.util.Map<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1>();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] stop
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
						"enc:routine.encryption.key.v1:upCUqrWmHQoSSit9lheFXcEM5dZ8bKZEt4vMNTjhECDiUg==");

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

				String dbquery_tDBInput_1 = "SELECT dbo.staging_trafic.trafic_id,\n		dbo.staging_trafic.time_id,\n		dbo.staging_trafic.zone_id,\n		dbo.staging_trafic.v"
						+ "itesse_kmh,\n		dbo.staging_trafic.temps_trajet_min,\n		dbo.staging_trafic.congestion_index,\n		dbo.staging_trafic.source_se"
						+ "nsor\nFROM	dbo.staging_trafic";

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
							row1.time_id = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.time_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.time_id = tmpContent_tDBInput_1;
								}
							} else {
								row1.time_id = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.zone_id = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.zone_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.zone_id = tmpContent_tDBInput_1;
								}
							} else {
								row1.zone_id = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.source_sensor = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.source_sensor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.source_sensor = tmpContent_tDBInput_1;
								}
							} else {
								row1.source_sensor = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.vitesse_kmh = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.vitesse_kmh = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.vitesse_kmh = tmpContent_tDBInput_1;
								}
							} else {
								row1.vitesse_kmh = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.temps_trajet_min = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.temps_trajet_min = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.temps_trajet_min = tmpContent_tDBInput_1;
								}
							} else {
								row1.temps_trajet_min = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.congestion_index = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.congestion_index = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.congestion_index = tmpContent_tDBInput_1;
								}
							} else {
								row1.congestion_index = null;
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
						 * [tAggregateRow_1_AGGOUT main ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						operation_finder_tAggregateRow_1.time_id = row1.time_id;
						operation_finder_tAggregateRow_1.zone_id = row1.zone_id;

						operation_finder_tAggregateRow_1.hashCodeDirty = true;

						operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

						boolean isFirstAdd_tAggregateRow_1 = false;

						if (operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

							operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

							operation_result_tAggregateRow_1.time_id = operation_finder_tAggregateRow_1.time_id;
							operation_result_tAggregateRow_1.zone_id = operation_finder_tAggregateRow_1.zone_id;

							isFirstAdd_tAggregateRow_1 = true;

							hash_tAggregateRow_1.put(operation_result_tAggregateRow_1,
									operation_result_tAggregateRow_1);

						} // G_OutMain_AggR_001

						if (isFirstAdd_tAggregateRow_1) {
							operation_result_tAggregateRow_1.source_sensor_first = row1.source_sensor;
						}

						tos_count_tAggregateRow_1_AGGOUT++;

						/**
						 * [tAggregateRow_1_AGGOUT main ] stop
						 */

						/**
						 * [tAggregateRow_1_AGGOUT process_data_begin ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						/**
						 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
						 */

						/**
						 * [tAggregateRow_1_AGGOUT process_data_end ] start
						 */

						currentVirtualComponent = "tAggregateRow_1";

						currentComponent = "tAggregateRow_1_AGGOUT";

						/**
						 * [tAggregateRow_1_AGGOUT process_data_end ] stop
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
				 * [tAggregateRow_1_AGGOUT end ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tAggregateRow_1_AGGOUT", true);
				end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGOUT end ] stop
				 */

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
						"enc:routine.encryption.key.v1:2SmPxW8DRugYtRUw7GA5ZvqGjJb/afWjaC+8f+W2QX8FcQ==");

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
					tableName_tDBOutput_1 = "facttrfic";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "facttrfic";
				}
				int count_tDBOutput_1 = 0;

				boolean whetherExist_tDBOutput_1 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					try {
						isExistStmt_tDBOutput_1.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_1 + "]");
						whetherExist_tDBOutput_1 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_1 = false;
					}
				}
				if (whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						stmtDrop_tDBOutput_1.execute("DROP TABLE [" + tableName_tDBOutput_1 + "]");
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1
							+ "]([vitesse_kmh] REAL ,[temps_trajet_min] REAL ,[congestion_index] REAL ,[fkzone_id] INT ,[fkmeteo] INT ,[fksensor] INT ,[fkevent] INT ,[date_id] INT )");
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([vitesse_kmh],[temps_trajet_min],[congestion_index],[fkzone_id],[fkmeteo],[fksensor],[fkevent],[date_id]) VALUES (?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
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
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGIN", false);
				start_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				int tos_count_tAggregateRow_1_AGGIN = 0;

				java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1
						.values();

				globalMap.put("tAggregateRow_1_NB_LINE", values_tAggregateRow_1.size());

				for (AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600

					/**
					 * [tAggregateRow_1_AGGIN begin ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN main ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					String s_time_id_time_id_tAggregateRow_1 = String.valueOf(aggregated_row_tAggregateRow_1.time_id);
					row7.time_id = ParserUtils.parseTo_Integer(s_time_id_time_id_tAggregateRow_1);

					String s_zone_id_zone_id_tAggregateRow_1 = String.valueOf(aggregated_row_tAggregateRow_1.zone_id);
					row7.zone_id = ParserUtils.parseTo_Integer(s_zone_id_zone_id_tAggregateRow_1);

					row7.source_sensor = aggregated_row_tAggregateRow_1.source_sensor_first;

					tos_count_tAggregateRow_1_AGGIN++;

					/**
					 * [tAggregateRow_1_AGGIN main ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] stop
					 */

					/**
					 * [tMap_1 main ] start
					 */

					currentComponent = "tMap_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row7"

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

						Object exprKeyValue_row2__time_id = row7.time_id;
						if (exprKeyValue_row2__time_id == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row2HashKey.time_id = (int) (Integer) exprKeyValue_row2__time_id;
						}

						row2HashKey.hashCodeDirty = true;

						if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

							tHash_Lookup_row2.lookup(row2HashKey);

						} // G_TM_M_091

					} // G_TM_M_020

					if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
						// and it contains more one result from keys : row2.time_id = '" +
						// row2HashKey.time_id + "'");
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

						Object exprKeyValue_row3__zone_id = row7.zone_id;
						if (exprKeyValue_row3__zone_id == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row3HashKey.zone_id = (int) (Integer) exprKeyValue_row3__zone_id;
						}

						row3HashKey.hashCodeDirty = true;

						if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

							tHash_Lookup_row3.lookup(row3HashKey);

						} // G_TM_M_091

					} // G_TM_M_020

					if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
						// and it contains more one result from keys : row3.zone_id = '" +
						// row3HashKey.zone_id + "'");
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

						row4HashKey.nomsensor = row7.source_sensor;

						row4HashKey.hashCodeDirty = true;

						tHash_Lookup_row4.lookup(row4HashKey);

					} // G_TM_M_020

					if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
						// and it contains more one result from keys : row4.nomsensor = '" +
						// row4HashKey.nomsensor + "'");
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

						row5HashKey.fkzone_id = row7.zone_id;

						Object exprKeyValue_row5__fkmois_id = row2.mois_id;
						if (exprKeyValue_row5__fkmois_id == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row5HashKey.fkmois_id = (int) (Integer) exprKeyValue_row5__fkmois_id;
						}

						row5HashKey.hashCodeDirty = true;

						if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

							tHash_Lookup_row5.lookup(row5HashKey);

						} // G_TM_M_091

					} // G_TM_M_020

					if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
						// and it contains more one result from keys : row5.fkzone_id = '" +
						// row5HashKey.fkzone_id + "', row5.fkmois_id = '" + row5HashKey.fkmois_id +
						// "'");
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

						Object exprKeyValue_row6__fkzone_id = row7.zone_id;
						if (exprKeyValue_row6__fkzone_id == null) {
							hasCasePrimitiveKeyWithNull_tMap_1 = true;
						} else {
							row6HashKey.fkzone_id = (int) (Integer) exprKeyValue_row6__fkzone_id;
						}

						Object exprKeyValue_row6__fkmois_id = row2.mois_id;
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

// # Output table : 'out1'
						out1_tmp.vitesse_kmh = (row7.vitesse_kmh == null || row7.vitesse_kmh > 150f) ? 28.11f
								: row7.vitesse_kmh;
						out1_tmp.temps_trajet_min = (row7.temps_trajet_min == null || row7.temps_trajet_min < 0f)
								? 17.92f
								: row7.temps_trajet_min;
						out1_tmp.congestion_index = row7.congestion_index == null ? 2f : row7.congestion_index;
						out1_tmp.fkzone_id = row3.zone_id;
						out1_tmp.fkmeteo = row5 == null ? -1 : row5.skmeteo;
						out1_tmp.fksensor = row4 == null ? -1 : row4.sksensor;
						out1_tmp.fkevent = row6 == null ? -1 : row6.skevent;
						out1_tmp.date_id = row2.date_id;
						out1 = out1_tmp;
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
						if (out1.vitesse_kmh == null) {
							pstmt_tDBOutput_1.setNull(1, java.sql.Types.FLOAT);
						} else {
							pstmt_tDBOutput_1.setFloat(1, out1.vitesse_kmh);
						}

						if (out1.temps_trajet_min == null) {
							pstmt_tDBOutput_1.setNull(2, java.sql.Types.FLOAT);
						} else {
							pstmt_tDBOutput_1.setFloat(2, out1.temps_trajet_min);
						}

						if (out1.congestion_index == null) {
							pstmt_tDBOutput_1.setNull(3, java.sql.Types.FLOAT);
						} else {
							pstmt_tDBOutput_1.setFloat(3, out1.congestion_index);
						}

						if (out1.fkzone_id == null) {
							pstmt_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(4, out1.fkzone_id);
						}

						if (out1.fkmeteo == null) {
							pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(5, out1.fkmeteo);
						}

						if (out1.fksensor == null) {
							pstmt_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(6, out1.fksensor);
						}

						if (out1.fkevent == null) {
							pstmt_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(7, out1.fkevent);
						}

						if (out1.date_id == null) {
							pstmt_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
						} else {
							pstmt_tDBOutput_1.setInt(8, out1.date_id);
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
						if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

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

					/**
					 * [tMap_1 process_data_end ] start
					 */

					currentComponent = "tMap_1";

					/**
					 * [tMap_1 process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

				} // G_AggR_600

				ok_Hash.put("tAggregateRow_1_AGGIN", true);
				end_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGIN end ] stop
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
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

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

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

			// free memory for "tAggregateRow_1_AGGIN"
			globalMap.remove("tAggregateRow_1");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGOUT finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				/**
				 * [tAggregateRow_1_AGGOUT finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				/**
				 * [tAggregateRow_1_AGGIN finally ] stop
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

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];
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

				result = prime * result + (int) this.time_id;

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

			if (this.time_id != other.time_id)
				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

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

		public void copyKeysDataTo(row2Struct other) {

			other.time_id = this.time_id;

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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.time_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.time_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.time_id);

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

				this.date_id = dis.readInt();

				this.mois_id = dis.readInt();

				this.BK_date = readDate(dis, ois);

				this.heure = readString(dis, ois);

				this.annee = dis.readInt();

				this.mois = dis.readInt();

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

				this.date_id = objectIn.readInt();

				this.mois_id = objectIn.readInt();

				this.BK_date = readDate(dis, objectIn);

				this.heure = readString(dis, objectIn);

				this.annee = objectIn.readInt();

				this.mois = objectIn.readInt();

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

				dos.writeInt(this.date_id);

				dos.writeInt(this.mois_id);

				writeDate(this.BK_date, dos, oos);

				writeString(this.heure, dos, oos);

				dos.writeInt(this.annee);

				dos.writeInt(this.mois);

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

				objectOut.writeInt(this.date_id);

				objectOut.writeInt(this.mois_id);

				writeDate(this.BK_date, dos, objectOut);

				writeString(this.heure, dos, objectOut);

				objectOut.writeInt(this.annee);

				objectOut.writeInt(this.mois);

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
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.time_id, other.time_id);
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
				// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row7,row2,row3,row4,row5,row6) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
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
						"enc:routine.encryption.key.v1:fiea0lxB0XHsaxflEIa9pzlJRWdPO97Vs+EZWz2NlHrfjQ==");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String port_tDBInput_2 = "1433";
				String dbname_tDBInput_2 = "dwurbanmobility";
				String url_tDBInput_2 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_2)) {
					url_tDBInput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_2)) {
					url_tDBInput_2 += ";databaseName=" + "dwurbanmobility";
				}
				url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_2 = "";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT DIM_TEMPS.time_id,\n		DIM_TEMPS.date_id,\n		DIM_TEMPS.mois_id,\n		DIM_TEMPS.BK_date,\n		DIM_TEMPS.heure,\n		DIM_TEMPS"
						+ ".annee,\n		DIM_TEMPS.mois,\n		DIM_TEMPS.jour,\n		DIM_TEMPS.jour_semaine,\n		DIM_TEMPS.est_weekend,\n		DIM_TEMPS.periode\nFROM	"
						+ "DIM_TEMPS";

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
							row2.time_id = 0;
						} else {

							row2.time_id = rs_tDBInput_2.getInt(1);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row2.date_id = 0;
						} else {

							row2.date_id = rs_tDBInput_2.getInt(2);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row2.mois_id = 0;
						} else {

							row2.mois_id = rs_tDBInput_2.getInt(3);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row2.BK_date = null;
						} else {

							row2.BK_date = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 4);

						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row2.heure = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.heure = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.heure = tmpContent_tDBInput_2;
								}
							} else {
								row2.heure = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row2.annee = 0;
						} else {

							row2.annee = rs_tDBInput_2.getInt(6);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row2.mois = 0;
						} else {

							row2.mois = rs_tDBInput_2.getInt(7);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							row2.jour = 0;
						} else {

							row2.jour = rs_tDBInput_2.getInt(8);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							row2.jour_semaine = 0;
						} else {

							row2.jour_semaine = rs_tDBInput_2.getInt(9);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							row2.est_weekend = false;
						} else {

							row2.est_weekend = rs_tDBInput_2.getBoolean(10);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 11) {
							row2.periode = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.periode = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.periode = tmpContent_tDBInput_2;
								}
							} else {
								row2.periode = null;
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
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row2"

							);
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.time_id = row2.time_id;

						row2_HashRow.date_id = row2.date_id;

						row2_HashRow.mois_id = row2.mois_id;

						row2_HashRow.BK_date = row2.BK_date;

						row2_HashRow.heure = row2.heure;

						row2_HashRow.annee = row2.annee;

						row2_HashRow.mois = row2.mois;

						row2_HashRow.jour = row2.jour;

						row2_HashRow.jour_semaine = row2.jour_semaine;

						row2_HashRow.est_weekend = row2.est_weekend;

						row2_HashRow.periode = row2.periode;

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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
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

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];
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
			final row3Struct other = (row3Struct) obj;

			if (this.zone_id != other.zone_id)
				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.zone_id = this.zone_id;
			other.zone_nom = this.zone_nom;
			other.ville = this.ville;
			other.region = this.region;
			other.pays = this.pays;
			other.code_insee_commune = this.code_insee_commune;
			other.lat_centre = this.lat_centre;
			other.lon_centre = this.lon_centre;

		}

		public void copyKeysDataTo(row3Struct other) {

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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.zone_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

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
		public int compareTo(row3Struct other) {

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
				// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row7,row2,row3,row4,row5,row6) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
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
						"enc:routine.encryption.key.v1:PrcKUGgFn6GQ4QjlsE3mA/Epo2QsYGKEJVKkJnh5PIj7pg==");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String port_tDBInput_3 = "1433";
				String dbname_tDBInput_3 = "dwurbanmobility";
				String url_tDBInput_3 = "jdbc:sqlserver://" + "NEGRAMARIEM";
				if (!"".equals(port_tDBInput_3)) {
					url_tDBInput_3 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_3)) {
					url_tDBInput_3 += ";databaseName=" + "dwurbanmobility";
				}
				url_tDBInput_3 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true";
				String dbschema_tDBInput_3 = "";

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT dimzones.zone_id,\n		dimzones.zone_nom,\n		dimzones.ville,\n		dimzones.region,\n		dimzones.pays,\n		dimzones.code_ins"
						+ "ee_commune,\n		dimzones.lat_centre,\n		dimzones.lon_centre\nFROM	dimzones";

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
							row3.zone_id = 0;
						} else {

							row3.zone_id = rs_tDBInput_3.getInt(1);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row3.zone_nom = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.zone_nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.zone_nom = tmpContent_tDBInput_3;
								}
							} else {
								row3.zone_nom = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row3.ville = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.ville = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.ville = tmpContent_tDBInput_3;
								}
							} else {
								row3.ville = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row3.region = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.region = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.region = tmpContent_tDBInput_3;
								}
							} else {
								row3.region = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row3.pays = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.pays = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.pays = tmpContent_tDBInput_3;
								}
							} else {
								row3.pays = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row3.code_insee_commune = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.code_insee_commune = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.code_insee_commune = tmpContent_tDBInput_3;
								}
							} else {
								row3.code_insee_commune = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row3.lat_centre = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.lat_centre = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.lat_centre = tmpContent_tDBInput_3;
								}
							} else {
								row3.lat_centre = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							row3.lon_centre = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(8);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.lon_centre = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.lon_centre = tmpContent_tDBInput_3;
								}
							} else {
								row3.lon_centre = null;
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

						row3_HashRow.zone_nom = row3.zone_nom;

						row3_HashRow.ville = row3.ville;

						row3_HashRow.region = row3.region;

						row3_HashRow.pays = row3.pays;

						row3_HashRow.code_insee_commune = row3.code_insee_commune;

						row3_HashRow.lat_centre = row3.lat_centre;

						row3_HashRow.lon_centre = row3.lon_centre;

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
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
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

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String nomsensor;

		public String getNomsensor() {
			return this.nomsensor;
		}

		public int sksensor;

		public int getSksensor() {
			return this.sksensor;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.nomsensor == null) ? 0 : this.nomsensor.hashCode());

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

			if (this.nomsensor == null) {
				if (other.nomsensor != null)
					return false;

			} else if (!this.nomsensor.equals(other.nomsensor))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.nomsensor = this.nomsensor;
			other.sksensor = this.sksensor;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.nomsensor = this.nomsensor;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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
				if (length > commonByteArray_LOCAL_PROJECT_facttrafic.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_facttrafic.length == 0) {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_facttrafic = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_facttrafic, 0, length, utf8Charset);
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

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.nomsensor = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.nomsensor = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.nomsensor, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.nomsensor, dos);

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

				this.sksensor = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.sksensor = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.sksensor);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.sksensor);

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
			sb.append("nomsensor=" + nomsensor);
			sb.append(",sksensor=" + String.valueOf(sksensor));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.nomsensor, other.nomsensor);
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
				// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row4,row4) |
				// target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
				// linked node: tMap_1 - inputs:(row7,row2,row3,row4,row5,row6) outputs:(out1)

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
						"enc:routine.encryption.key.v1:d1Z0Y/73glgG+/7lSxj+RI0od4Ts2L285Yh0C6WThNpD3Q==");

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

				String dbquery_tDBInput_4 = "SELECT dimsensor.nomsensor,\n		dimsensor.sksensor\nFROM	dimsensor";

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
							row4.nomsensor = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(1);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row4.nomsensor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row4.nomsensor = tmpContent_tDBInput_4;
								}
							} else {
								row4.nomsensor = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row4.sksensor = 0;
						} else {

							row4.sksensor = rs_tDBInput_4.getInt(2);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
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

						row4_HashRow.nomsensor = row4.nomsensor;

						row4_HashRow.sksensor = row4.sksensor;

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
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer fkzone_id;

		public Integer getFkzone_id() {
			return this.fkzone_id;
		}

		public String station_id;

		public String getStation_id() {
			return this.station_id;
		}

		public Boolean pluie_forte;

		public Boolean getPluie_forte() {
			return this.pluie_forte;
		}

		public Boolean pluie_intense;

		public Boolean getPluie_intense() {
			return this.pluie_intense;
		}

		public Boolean mois_gel;

		public Boolean getMois_gel() {
			return this.mois_gel;
		}

		public Boolean risque_verglas;

		public Boolean getRisque_verglas() {
			return this.risque_verglas;
		}

		public Boolean risque_neige;

		public Boolean getRisque_neige() {
			return this.risque_neige;
		}

		public String categories_meteo;

		public String getCategories_meteo() {
			return this.categories_meteo;
		}

		public int fkmois_id;

		public int getFkmois_id() {
			return this.fkmois_id;
		}

		public int skmeteo;

		public int getSkmeteo() {
			return this.skmeteo;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.fkzone_id == null) ? 0 : this.fkzone_id.hashCode());

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
			final row5Struct other = (row5Struct) obj;

			if (this.fkzone_id == null) {
				if (other.fkzone_id != null)
					return false;

			} else if (!this.fkzone_id.equals(other.fkzone_id))

				return false;

			if (this.fkmois_id != other.fkmois_id)
				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.fkzone_id = this.fkzone_id;
			other.station_id = this.station_id;
			other.pluie_forte = this.pluie_forte;
			other.pluie_intense = this.pluie_intense;
			other.mois_gel = this.mois_gel;
			other.risque_verglas = this.risque_verglas;
			other.risque_neige = this.risque_neige;
			other.categories_meteo = this.categories_meteo;
			other.fkmois_id = this.fkmois_id;
			other.skmeteo = this.skmeteo;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.fkzone_id = this.fkzone_id;
			other.fkmois_id = this.fkmois_id;

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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.fkzone_id = readInteger(dis);

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

				try {

					int length = 0;

					this.fkzone_id = readInteger(dis);

					this.fkmois_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.fkzone_id, dos);

				// int

				dos.writeInt(this.fkmois_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.fkzone_id, dos);

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

				this.station_id = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.pluie_forte = null;
				} else {
					this.pluie_forte = dis.readBoolean();
				}

				length = dis.readByte();
				if (length == -1) {
					this.pluie_intense = null;
				} else {
					this.pluie_intense = dis.readBoolean();
				}

				length = dis.readByte();
				if (length == -1) {
					this.mois_gel = null;
				} else {
					this.mois_gel = dis.readBoolean();
				}

				length = dis.readByte();
				if (length == -1) {
					this.risque_verglas = null;
				} else {
					this.risque_verglas = dis.readBoolean();
				}

				length = dis.readByte();
				if (length == -1) {
					this.risque_neige = null;
				} else {
					this.risque_neige = dis.readBoolean();
				}

				this.categories_meteo = readString(dis, ois);

				this.skmeteo = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.station_id = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.pluie_forte = null;
				} else {
					this.pluie_forte = objectIn.readBoolean();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.pluie_intense = null;
				} else {
					this.pluie_intense = objectIn.readBoolean();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.mois_gel = null;
				} else {
					this.mois_gel = objectIn.readBoolean();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.risque_verglas = null;
				} else {
					this.risque_verglas = objectIn.readBoolean();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.risque_neige = null;
				} else {
					this.risque_neige = objectIn.readBoolean();
				}

				this.categories_meteo = readString(dis, objectIn);

				this.skmeteo = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.station_id, dos, oos);

				if (this.pluie_forte == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.pluie_forte);
				}

				if (this.pluie_intense == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.pluie_intense);
				}

				if (this.mois_gel == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.mois_gel);
				}

				if (this.risque_verglas == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.risque_verglas);
				}

				if (this.risque_neige == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.risque_neige);
				}

				writeString(this.categories_meteo, dos, oos);

				dos.writeInt(this.skmeteo);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.station_id, dos, objectOut);

				if (this.pluie_forte == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeBoolean(this.pluie_forte);
				}

				if (this.pluie_intense == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeBoolean(this.pluie_intense);
				}

				if (this.mois_gel == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeBoolean(this.mois_gel);
				}

				if (this.risque_verglas == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeBoolean(this.risque_verglas);
				}

				if (this.risque_neige == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeBoolean(this.risque_neige);
				}

				writeString(this.categories_meteo, dos, objectOut);

				objectOut.writeInt(this.skmeteo);

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
			sb.append("fkzone_id=" + String.valueOf(fkzone_id));
			sb.append(",station_id=" + station_id);
			sb.append(",pluie_forte=" + String.valueOf(pluie_forte));
			sb.append(",pluie_intense=" + String.valueOf(pluie_intense));
			sb.append(",mois_gel=" + String.valueOf(mois_gel));
			sb.append(",risque_verglas=" + String.valueOf(risque_verglas));
			sb.append(",risque_neige=" + String.valueOf(risque_neige));
			sb.append(",categories_meteo=" + categories_meteo);
			sb.append(",fkmois_id=" + String.valueOf(fkmois_id));
			sb.append(",skmeteo=" + String.valueOf(skmeteo));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

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
				// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row5,row5) |
				// target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
				// linked node: tMap_1 - inputs:(row7,row2,row3,row4,row5,row6) outputs:(out1)

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
						"enc:routine.encryption.key.v1:AZNy9C5gvw7LoSskQ2BCWBd5Vjso6ivf1Z1ONk12AjEspA==");

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

				String dbquery_tDBInput_5 = "SELECT dimmeteoo.fkzone_id,\n		dimmeteoo.station_id,\n		dimmeteoo.pluie_forte,\n		dimmeteoo.pluie_intense,\n		dimmeteoo.moi"
						+ "s_gel,\n		dimmeteoo.risque_verglas,\n		dimmeteoo.risque_neige,\n		dimmeteoo.categories_meteo,\n		dimmeteoo.fkmois_id,\n		dimm"
						+ "eteoo.skmeteo\nFROM	dimmeteoo";

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
							row5.fkzone_id = null;
						} else {

							row5.fkzone_id = rs_tDBInput_5.getInt(1);
							if (rs_tDBInput_5.wasNull()) {
								row5.fkzone_id = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row5.station_id = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.station_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.station_id = tmpContent_tDBInput_5;
								}
							} else {
								row5.station_id = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 3) {
							row5.pluie_forte = null;
						} else {

							row5.pluie_forte = rs_tDBInput_5.getBoolean(3);
							if (rs_tDBInput_5.wasNull()) {
								row5.pluie_forte = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 4) {
							row5.pluie_intense = null;
						} else {

							row5.pluie_intense = rs_tDBInput_5.getBoolean(4);
							if (rs_tDBInput_5.wasNull()) {
								row5.pluie_intense = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 5) {
							row5.mois_gel = null;
						} else {

							row5.mois_gel = rs_tDBInput_5.getBoolean(5);
							if (rs_tDBInput_5.wasNull()) {
								row5.mois_gel = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 6) {
							row5.risque_verglas = null;
						} else {

							row5.risque_verglas = rs_tDBInput_5.getBoolean(6);
							if (rs_tDBInput_5.wasNull()) {
								row5.risque_verglas = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 7) {
							row5.risque_neige = null;
						} else {

							row5.risque_neige = rs_tDBInput_5.getBoolean(7);
							if (rs_tDBInput_5.wasNull()) {
								row5.risque_neige = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 8) {
							row5.categories_meteo = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(8);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.categories_meteo = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row5.categories_meteo = tmpContent_tDBInput_5;
								}
							} else {
								row5.categories_meteo = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 9) {
							row5.fkmois_id = 0;
						} else {

							row5.fkmois_id = rs_tDBInput_5.getInt(9);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 10) {
							row5.skmeteo = 0;
						} else {

							row5.skmeteo = rs_tDBInput_5.getInt(10);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
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

						row5_HashRow.fkzone_id = row5.fkzone_id;

						row5_HashRow.station_id = row5.station_id;

						row5_HashRow.pluie_forte = row5.pluie_forte;

						row5_HashRow.pluie_intense = row5.pluie_intense;

						row5_HashRow.mois_gel = row5.mois_gel;

						row5_HashRow.risque_verglas = row5.risque_verglas;

						row5_HashRow.risque_neige = row5.risque_neige;

						row5_HashRow.categories_meteo = row5.categories_meteo;

						row5_HashRow.fkmois_id = row5.fkmois_id;

						row5_HashRow.skmeteo = row5.skmeteo;

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
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_facttrafic = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_facttrafic = new byte[0];
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

		public int skevent;

		public int getSkevent() {
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

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_facttrafic) {

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

				this.skevent = dis.readInt();

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

				this.skevent = objectIn.readInt();

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

				dos.writeInt(this.skevent);

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

				objectOut.writeInt(this.skevent);

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
				// source node:tDBInput_6 - inputs:(after_tDBInput_1) outputs:(row6,row6) |
				// target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row7,row2,row3,row4,row5,row6) outputs:(out1)

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
						"enc:routine.encryption.key.v1:whDMV+7Y4l/4CPrlBUYz2w4zXojtD09Ny7wxyn/+9ryuyA==");

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
							row6.skevent = 0;
						} else {

							row6.skevent = rs_tDBInput_6.getInt(11);
							if (rs_tDBInput_6.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
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
		final facttrafic facttraficClass = new facttrafic();

		int exitCode = facttraficClass.runJobInTOS(args);

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
			java.io.InputStream inContext = facttrafic.class.getClassLoader()
					.getResourceAsStream("local_project/facttrafic_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = facttrafic.class.getClassLoader()
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
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : facttrafic");
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
 * 252494 characters generated by Talend Open Studio for Data Integration on the
 * 3 mars 2026 à 16:32:14 WAT
 ************************************************************************************************/