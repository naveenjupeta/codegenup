import json

class ETLClient:
    def run(self, service, max_requests):
        documents = []

        documents.append({
                            'doc-count': 0,
                            'error-count': 0,
                            'docs': {}
                            })

        for i in range(0, max_requests):

            while True:

                try:
                    event = service.handle_request()

                    if event['operation'] == 'add':
                        doc_id = event['document']['id']
                        doc_data = self.remove_words(event['document']['data'])
                        documents[0]['docs'][doc_id] = doc_data
                        documents[0]['doc-count'] = documents[0].get('doc-count') + 1

                    if event['operation'] == 'update':
                        doc_id = event['document']['id']
                        doc_data = self.remove_words(event['document']['data'])
                        documents[0]['docs'][doc_id] = doc_data

                    if event['operation'] == 'delete':
                        doc_id = event['document-id']
                        docs = documents[0]['docs']
                        for docid, data in docs.items():
                          if docid == doc_id:
                              del docs[docid]
                        documents[0]['doc-count'] = documents[0].get('doc-count') - 1

                except RetryImmediatelyError:
                    documents[0]['error-count'] = documents[0].get('error-count') + 1
                    continue

                break

        return json.dumps(documents[0])


    def remove_words(self, string):
        remove_words = set(['and', 'or', 'not', 'but', 'to', 'in'])
        words = string.lower().split(' ')

        for word in words:
            if word in remove_words:
                words.remove(word)
