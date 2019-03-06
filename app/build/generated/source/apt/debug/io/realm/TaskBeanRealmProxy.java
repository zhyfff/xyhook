package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class TaskBeanRealmProxy extends com.Realm.entry.TaskBean
    implements RealmObjectProxy, TaskBeanRealmProxyInterface {

    static final class TaskBeanColumnInfo extends ColumnInfo {
        long seqIndex;
        long startPageIndex;
        long endPageIndex;
        long flagIndex;
        long provinceIndex;
        long cityIndex;
        long areaIndex;

        TaskBeanColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("TaskBean");
            this.seqIndex = addColumnDetails("seq", objectSchemaInfo);
            this.startPageIndex = addColumnDetails("startPage", objectSchemaInfo);
            this.endPageIndex = addColumnDetails("endPage", objectSchemaInfo);
            this.flagIndex = addColumnDetails("flag", objectSchemaInfo);
            this.provinceIndex = addColumnDetails("province", objectSchemaInfo);
            this.cityIndex = addColumnDetails("city", objectSchemaInfo);
            this.areaIndex = addColumnDetails("area", objectSchemaInfo);
        }

        TaskBeanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TaskBeanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TaskBeanColumnInfo src = (TaskBeanColumnInfo) rawSrc;
            final TaskBeanColumnInfo dst = (TaskBeanColumnInfo) rawDst;
            dst.seqIndex = src.seqIndex;
            dst.startPageIndex = src.startPageIndex;
            dst.endPageIndex = src.endPageIndex;
            dst.flagIndex = src.flagIndex;
            dst.provinceIndex = src.provinceIndex;
            dst.cityIndex = src.cityIndex;
            dst.areaIndex = src.areaIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(7);
        fieldNames.add("seq");
        fieldNames.add("startPage");
        fieldNames.add("endPage");
        fieldNames.add("flag");
        fieldNames.add("province");
        fieldNames.add("city");
        fieldNames.add("area");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private TaskBeanColumnInfo columnInfo;
    private ProxyState<com.Realm.entry.TaskBean> proxyState;

    TaskBeanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaskBeanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.Realm.entry.TaskBean>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$seq() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.seqIndex);
    }

    @Override
    public void realmSet$seq(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'seq' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$startPage() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.startPageIndex);
    }

    @Override
    public void realmSet$startPage(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.startPageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.startPageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$endPage() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.endPageIndex);
    }

    @Override
    public void realmSet$endPage(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.endPageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.endPageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$flag() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.flagIndex);
    }

    @Override
    public void realmSet$flag(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.flagIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.flagIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.flagIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.flagIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$province() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.provinceIndex);
    }

    @Override
    public void realmSet$province(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.provinceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.provinceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.provinceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.provinceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$city() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityIndex);
    }

    @Override
    public void realmSet$city(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$area() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.areaIndex);
    }

    @Override
    public void realmSet$area(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.areaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.areaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.areaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.areaIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("TaskBean", 7, 0);
        builder.addPersistedProperty("seq", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("startPage", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("endPage", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("flag", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("province", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("city", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("area", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TaskBeanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TaskBeanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "TaskBean";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.Realm.entry.TaskBean createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.Realm.entry.TaskBean obj = null;
        if (update) {
            Table table = realm.getTable(com.Realm.entry.TaskBean.class);
            TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
            long pkColumnIndex = columnInfo.seqIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("seq")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("seq"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class), false, Collections.<String> emptyList());
                    obj = new io.realm.TaskBeanRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("seq")) {
                if (json.isNull("seq")) {
                    obj = (io.realm.TaskBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.TaskBean.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.TaskBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.TaskBean.class, json.getInt("seq"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'seq'.");
            }
        }

        final TaskBeanRealmProxyInterface objProxy = (TaskBeanRealmProxyInterface) obj;
        if (json.has("startPage")) {
            if (json.isNull("startPage")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'startPage' to null.");
            } else {
                objProxy.realmSet$startPage((int) json.getInt("startPage"));
            }
        }
        if (json.has("endPage")) {
            if (json.isNull("endPage")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'endPage' to null.");
            } else {
                objProxy.realmSet$endPage((int) json.getInt("endPage"));
            }
        }
        if (json.has("flag")) {
            if (json.isNull("flag")) {
                objProxy.realmSet$flag(null);
            } else {
                objProxy.realmSet$flag((String) json.getString("flag"));
            }
        }
        if (json.has("province")) {
            if (json.isNull("province")) {
                objProxy.realmSet$province(null);
            } else {
                objProxy.realmSet$province((String) json.getString("province"));
            }
        }
        if (json.has("city")) {
            if (json.isNull("city")) {
                objProxy.realmSet$city(null);
            } else {
                objProxy.realmSet$city((String) json.getString("city"));
            }
        }
        if (json.has("area")) {
            if (json.isNull("area")) {
                objProxy.realmSet$area(null);
            } else {
                objProxy.realmSet$area((String) json.getString("area"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.Realm.entry.TaskBean createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.Realm.entry.TaskBean obj = new com.Realm.entry.TaskBean();
        final TaskBeanRealmProxyInterface objProxy = (TaskBeanRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("seq")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$seq((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'seq' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("startPage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$startPage((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'startPage' to null.");
                }
            } else if (name.equals("endPage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$endPage((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'endPage' to null.");
                }
            } else if (name.equals("flag")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$flag((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$flag(null);
                }
            } else if (name.equals("province")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$province((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$province(null);
                }
            } else if (name.equals("city")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$city((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$city(null);
                }
            } else if (name.equals("area")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$area((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$area(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'seq'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.Realm.entry.TaskBean copyOrUpdate(Realm realm, com.Realm.entry.TaskBean object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.TaskBean) cachedRealmObject;
        }

        com.Realm.entry.TaskBean realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.Realm.entry.TaskBean.class);
            TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
            long pkColumnIndex = columnInfo.seqIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.TaskBeanRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.Realm.entry.TaskBean copy(Realm realm, com.Realm.entry.TaskBean newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.TaskBean) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.Realm.entry.TaskBean realmObject = realm.createObjectInternal(com.Realm.entry.TaskBean.class, ((TaskBeanRealmProxyInterface) newObject).realmGet$seq(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        TaskBeanRealmProxyInterface realmObjectSource = (TaskBeanRealmProxyInterface) newObject;
        TaskBeanRealmProxyInterface realmObjectCopy = (TaskBeanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$startPage(realmObjectSource.realmGet$startPage());
        realmObjectCopy.realmSet$endPage(realmObjectSource.realmGet$endPage());
        realmObjectCopy.realmSet$flag(realmObjectSource.realmGet$flag());
        realmObjectCopy.realmSet$province(realmObjectSource.realmGet$province());
        realmObjectCopy.realmSet$city(realmObjectSource.realmGet$city());
        realmObjectCopy.realmSet$area(realmObjectSource.realmGet$area());
        return realmObject;
    }

    public static long insert(Realm realm, com.Realm.entry.TaskBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.TaskBean.class);
        long tableNativePtr = table.getNativePtr();
        TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((TaskBeanRealmProxyInterface) object).realmGet$seq();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.startPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$startPage(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.endPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$endPage(), false);
        String realmGet$flag = ((TaskBeanRealmProxyInterface) object).realmGet$flag();
        if (realmGet$flag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.flagIndex, rowIndex, realmGet$flag, false);
        }
        String realmGet$province = ((TaskBeanRealmProxyInterface) object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        }
        String realmGet$city = ((TaskBeanRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        }
        String realmGet$area = ((TaskBeanRealmProxyInterface) object).realmGet$area();
        if (realmGet$area != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.TaskBean.class);
        long tableNativePtr = table.getNativePtr();
        TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        com.Realm.entry.TaskBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.TaskBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((TaskBeanRealmProxyInterface) object).realmGet$seq();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.startPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$startPage(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.endPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$endPage(), false);
            String realmGet$flag = ((TaskBeanRealmProxyInterface) object).realmGet$flag();
            if (realmGet$flag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.flagIndex, rowIndex, realmGet$flag, false);
            }
            String realmGet$province = ((TaskBeanRealmProxyInterface) object).realmGet$province();
            if (realmGet$province != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
            }
            String realmGet$city = ((TaskBeanRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            }
            String realmGet$area = ((TaskBeanRealmProxyInterface) object).realmGet$area();
            if (realmGet$area != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.Realm.entry.TaskBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.TaskBean.class);
        long tableNativePtr = table.getNativePtr();
        TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((TaskBeanRealmProxyInterface) object).realmGet$seq();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.startPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$startPage(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.endPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$endPage(), false);
        String realmGet$flag = ((TaskBeanRealmProxyInterface) object).realmGet$flag();
        if (realmGet$flag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.flagIndex, rowIndex, realmGet$flag, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.flagIndex, rowIndex, false);
        }
        String realmGet$province = ((TaskBeanRealmProxyInterface) object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
        }
        String realmGet$city = ((TaskBeanRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
        }
        String realmGet$area = ((TaskBeanRealmProxyInterface) object).realmGet$area();
        if (realmGet$area != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.areaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.TaskBean.class);
        long tableNativePtr = table.getNativePtr();
        TaskBeanColumnInfo columnInfo = (TaskBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.TaskBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        com.Realm.entry.TaskBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.TaskBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((TaskBeanRealmProxyInterface) object).realmGet$seq();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((TaskBeanRealmProxyInterface) object).realmGet$seq());
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.startPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$startPage(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.endPageIndex, rowIndex, ((TaskBeanRealmProxyInterface) object).realmGet$endPage(), false);
            String realmGet$flag = ((TaskBeanRealmProxyInterface) object).realmGet$flag();
            if (realmGet$flag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.flagIndex, rowIndex, realmGet$flag, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.flagIndex, rowIndex, false);
            }
            String realmGet$province = ((TaskBeanRealmProxyInterface) object).realmGet$province();
            if (realmGet$province != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
            }
            String realmGet$city = ((TaskBeanRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
            }
            String realmGet$area = ((TaskBeanRealmProxyInterface) object).realmGet$area();
            if (realmGet$area != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.areaIndex, rowIndex, false);
            }
        }
    }

    public static com.Realm.entry.TaskBean createDetachedCopy(com.Realm.entry.TaskBean realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.Realm.entry.TaskBean unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.Realm.entry.TaskBean();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.Realm.entry.TaskBean) cachedObject.object;
            }
            unmanagedObject = (com.Realm.entry.TaskBean) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        TaskBeanRealmProxyInterface unmanagedCopy = (TaskBeanRealmProxyInterface) unmanagedObject;
        TaskBeanRealmProxyInterface realmSource = (TaskBeanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$seq(realmSource.realmGet$seq());
        unmanagedCopy.realmSet$startPage(realmSource.realmGet$startPage());
        unmanagedCopy.realmSet$endPage(realmSource.realmGet$endPage());
        unmanagedCopy.realmSet$flag(realmSource.realmGet$flag());
        unmanagedCopy.realmSet$province(realmSource.realmGet$province());
        unmanagedCopy.realmSet$city(realmSource.realmGet$city());
        unmanagedCopy.realmSet$area(realmSource.realmGet$area());

        return unmanagedObject;
    }

    static com.Realm.entry.TaskBean update(Realm realm, com.Realm.entry.TaskBean realmObject, com.Realm.entry.TaskBean newObject, Map<RealmModel, RealmObjectProxy> cache) {
        TaskBeanRealmProxyInterface realmObjectTarget = (TaskBeanRealmProxyInterface) realmObject;
        TaskBeanRealmProxyInterface realmObjectSource = (TaskBeanRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$startPage(realmObjectSource.realmGet$startPage());
        realmObjectTarget.realmSet$endPage(realmObjectSource.realmGet$endPage());
        realmObjectTarget.realmSet$flag(realmObjectSource.realmGet$flag());
        realmObjectTarget.realmSet$province(realmObjectSource.realmGet$province());
        realmObjectTarget.realmSet$city(realmObjectSource.realmGet$city());
        realmObjectTarget.realmSet$area(realmObjectSource.realmGet$area());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TaskBean = proxy[");
        stringBuilder.append("{seq:");
        stringBuilder.append(realmGet$seq());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startPage:");
        stringBuilder.append(realmGet$startPage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endPage:");
        stringBuilder.append(realmGet$endPage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{flag:");
        stringBuilder.append(realmGet$flag() != null ? realmGet$flag() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{province:");
        stringBuilder.append(realmGet$province() != null ? realmGet$province() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{city:");
        stringBuilder.append(realmGet$city() != null ? realmGet$city() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{area:");
        stringBuilder.append(realmGet$area() != null ? realmGet$area() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskBeanRealmProxy aTaskBean = (TaskBeanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTaskBean.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTaskBean.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTaskBean.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
