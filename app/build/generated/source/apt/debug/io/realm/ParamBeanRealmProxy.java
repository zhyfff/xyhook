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
public class ParamBeanRealmProxy extends com.Realm.entry.ParamBean
    implements RealmObjectProxy, ParamBeanRealmProxyInterface {

    static final class ParamBeanColumnInfo extends ColumnInfo {
        long seqIndex;
        long resbodyIndex;

        ParamBeanColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ParamBean");
            this.seqIndex = addColumnDetails("seq", objectSchemaInfo);
            this.resbodyIndex = addColumnDetails("resbody", objectSchemaInfo);
        }

        ParamBeanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ParamBeanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ParamBeanColumnInfo src = (ParamBeanColumnInfo) rawSrc;
            final ParamBeanColumnInfo dst = (ParamBeanColumnInfo) rawDst;
            dst.seqIndex = src.seqIndex;
            dst.resbodyIndex = src.resbodyIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("seq");
        fieldNames.add("resbody");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ParamBeanColumnInfo columnInfo;
    private ProxyState<com.Realm.entry.ParamBean> proxyState;

    ParamBeanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ParamBeanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.Realm.entry.ParamBean>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$seq() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.seqIndex);
    }

    @Override
    public void realmSet$seq(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'seq' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$resbody() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.resbodyIndex);
    }

    @Override
    public void realmSet$resbody(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.resbodyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.resbodyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.resbodyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.resbodyIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ParamBean", 2, 0);
        builder.addPersistedProperty("seq", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("resbody", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ParamBeanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ParamBeanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ParamBean";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.Realm.entry.ParamBean createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.Realm.entry.ParamBean obj = null;
        if (update) {
            Table table = realm.getTable(com.Realm.entry.ParamBean.class);
            ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
            long pkColumnIndex = columnInfo.seqIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("seq")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("seq"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ParamBeanRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("seq")) {
                if (json.isNull("seq")) {
                    obj = (io.realm.ParamBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.ParamBean.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ParamBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.ParamBean.class, json.getString("seq"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'seq'.");
            }
        }

        final ParamBeanRealmProxyInterface objProxy = (ParamBeanRealmProxyInterface) obj;
        if (json.has("resbody")) {
            if (json.isNull("resbody")) {
                objProxy.realmSet$resbody(null);
            } else {
                objProxy.realmSet$resbody((String) json.getString("resbody"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.Realm.entry.ParamBean createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.Realm.entry.ParamBean obj = new com.Realm.entry.ParamBean();
        final ParamBeanRealmProxyInterface objProxy = (ParamBeanRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("seq")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$seq((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$seq(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("resbody")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$resbody((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$resbody(null);
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

    public static com.Realm.entry.ParamBean copyOrUpdate(Realm realm, com.Realm.entry.ParamBean object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.Realm.entry.ParamBean) cachedRealmObject;
        }

        com.Realm.entry.ParamBean realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.Realm.entry.ParamBean.class);
            ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
            long pkColumnIndex = columnInfo.seqIndex;
            String value = ((ParamBeanRealmProxyInterface) object).realmGet$seq();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.ParamBeanRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.Realm.entry.ParamBean copy(Realm realm, com.Realm.entry.ParamBean newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.ParamBean) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.Realm.entry.ParamBean realmObject = realm.createObjectInternal(com.Realm.entry.ParamBean.class, ((ParamBeanRealmProxyInterface) newObject).realmGet$seq(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ParamBeanRealmProxyInterface realmObjectSource = (ParamBeanRealmProxyInterface) newObject;
        ParamBeanRealmProxyInterface realmObjectCopy = (ParamBeanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$resbody(realmObjectSource.realmGet$resbody());
        return realmObject;
    }

    public static long insert(Realm realm, com.Realm.entry.ParamBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.ParamBean.class);
        long tableNativePtr = table.getNativePtr();
        ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        String primaryKeyValue = ((ParamBeanRealmProxyInterface) object).realmGet$seq();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$resbody = ((ParamBeanRealmProxyInterface) object).realmGet$resbody();
        if (realmGet$resbody != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.resbodyIndex, rowIndex, realmGet$resbody, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.ParamBean.class);
        long tableNativePtr = table.getNativePtr();
        ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        com.Realm.entry.ParamBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.ParamBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ParamBeanRealmProxyInterface) object).realmGet$seq();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$resbody = ((ParamBeanRealmProxyInterface) object).realmGet$resbody();
            if (realmGet$resbody != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.resbodyIndex, rowIndex, realmGet$resbody, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.Realm.entry.ParamBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.ParamBean.class);
        long tableNativePtr = table.getNativePtr();
        ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        String primaryKeyValue = ((ParamBeanRealmProxyInterface) object).realmGet$seq();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$resbody = ((ParamBeanRealmProxyInterface) object).realmGet$resbody();
        if (realmGet$resbody != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.resbodyIndex, rowIndex, realmGet$resbody, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.resbodyIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.ParamBean.class);
        long tableNativePtr = table.getNativePtr();
        ParamBeanColumnInfo columnInfo = (ParamBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.ParamBean.class);
        long pkColumnIndex = columnInfo.seqIndex;
        com.Realm.entry.ParamBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.ParamBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ParamBeanRealmProxyInterface) object).realmGet$seq();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$resbody = ((ParamBeanRealmProxyInterface) object).realmGet$resbody();
            if (realmGet$resbody != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.resbodyIndex, rowIndex, realmGet$resbody, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.resbodyIndex, rowIndex, false);
            }
        }
    }

    public static com.Realm.entry.ParamBean createDetachedCopy(com.Realm.entry.ParamBean realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.Realm.entry.ParamBean unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.Realm.entry.ParamBean();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.Realm.entry.ParamBean) cachedObject.object;
            }
            unmanagedObject = (com.Realm.entry.ParamBean) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ParamBeanRealmProxyInterface unmanagedCopy = (ParamBeanRealmProxyInterface) unmanagedObject;
        ParamBeanRealmProxyInterface realmSource = (ParamBeanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$seq(realmSource.realmGet$seq());
        unmanagedCopy.realmSet$resbody(realmSource.realmGet$resbody());

        return unmanagedObject;
    }

    static com.Realm.entry.ParamBean update(Realm realm, com.Realm.entry.ParamBean realmObject, com.Realm.entry.ParamBean newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ParamBeanRealmProxyInterface realmObjectTarget = (ParamBeanRealmProxyInterface) realmObject;
        ParamBeanRealmProxyInterface realmObjectSource = (ParamBeanRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$resbody(realmObjectSource.realmGet$resbody());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ParamBean = proxy[");
        stringBuilder.append("{seq:");
        stringBuilder.append(realmGet$seq() != null ? realmGet$seq() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{resbody:");
        stringBuilder.append(realmGet$resbody() != null ? realmGet$resbody() : "null");
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
        ParamBeanRealmProxy aParamBean = (ParamBeanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aParamBean.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aParamBean.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aParamBean.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
