import React from 'react'
import "./UpdateWindow.css"
import SubjectCheckbox from "./SubjectCheckbox/SubjectCheckbox"
import { JsxEmit } from 'typescript';
import ApiHandler from '../../API/ApiHandler'


interface UpdateWindowState {
    passedSubjectsCodes: string[],
    failedSubjectsCodes: string[],
    data: any
}

interface UpdateWindowProps {
    studentId: string
}

export class UpdateWindow extends React.Component<UpdateWindowProps, UpdateWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            passedSubjectsCodes: [],
            failedSubjectsCodes: [],
            data: {}
        }
        this.handlePassedClick = this.handlePassedClick.bind(this);
        this.handleFailedClick = this.handleFailedClick.bind(this);
    }

    handlePassedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!passed.includes(subjectCode)) {
            passed.push(subjectCode);
            if (failed.includes(subjectCode)) {
                failed.splice(failed.indexOf(subjectCode), 1);
            }
        } else {
            passed.splice(passed.indexOf(subjectCode), 1);
        }

        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    handleFailedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!failed.includes(subjectCode)) {
            failed.push(subjectCode);
            if (passed.includes(subjectCode)) {
                passed.splice(passed.indexOf(subjectCode), 1);
            }
        } else {
            failed.splice(failed.indexOf(subjectCode), 1);
        }

        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    componentDidMount() {
        new ApiHandler().getStudentData(this.props.studentId).then((d) => {
            console.log(d);
            this.setState({
                data: d
            });
        });
    }

    render() {
        if (!this.state.data.data) {
            console.log("NO DATA!");
            return (<div></div>);
        }
        const subjectCodes: string[] = this.state.data.data.subjectCodes.sistemas;

        subjectCodes.sort(function (a: string, b: string) {
            var keyA: number = Number(a);
            var keyB: number = Number(b);
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjectCheckboxes: JSX.Element[] = subjectCodes.map(s => {
            return (
                <SubjectCheckbox key={s}
                    code={s}
                    passed={this.state.passedSubjectsCodes.includes(s)}
                    failed={this.state.failedSubjectsCodes.includes(s)}
                    handlePassedClick={this.handlePassedClick}
                    handleFailedClick={this.handleFailedClick} />
            );
        })

        let subjectCheckboxesList1: any[] = [];
        let subjectCheckboxesList2: any[] = [];
        let subjectCheckboxesList3: any[] = [];
        let subjectCheckboxesList4: any[] = [];
        let listToAdd: number = 1;

        while (!(subjectCheckboxes.length === 0)) {

            switch (listToAdd) {
                case 1:
                    subjectCheckboxesList1.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                case 2:
                    subjectCheckboxesList2.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                case 3:
                    subjectCheckboxesList3.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                default:
                    subjectCheckboxesList4.push(subjectCheckboxes.shift());
                    listToAdd = 1;
                    break;
            }
        }

        return (
            <div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList1}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList2}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList3}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList4}</ul>
                </div>
            </div >
        );
    }
}
