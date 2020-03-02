/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize;

    void clear() {
        for (int i = 0, storageSize = size(); i < storageSize; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0, storageSize = size(); i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0, storageSize = size(); i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < storageSize; j++) {
                    if (j != storageSize - 1) {
                        storage[j] = storage[j + 1];
                    }
                    else {
                        storage[j] = null;
                        storageSize = size();
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0, storageSize = size(); i < storageSize; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            }
            else {
                break;
            }
        }
        return size;
    }
}
